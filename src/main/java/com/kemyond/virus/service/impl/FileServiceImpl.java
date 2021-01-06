package com.kemyond.virus.service.impl;

import com.kemyond.virus.clamav.ClamavCache;
import com.kemyond.virus.common.CodeMessage;
import com.kemyond.virus.common.Record;
import com.kemyond.virus.dao.HisVirusMapper;
import com.kemyond.virus.domain.HisVirus;
import com.kemyond.virus.service.FileService;
import com.kemyond.virus.util.ClamavUtil;
import com.kemyond.virus.util.StringUtils;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author zdl
 * @Date 2021/1/4 16:26
 * @Version 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    private  static final Logger log= LoggerFactory.getLogger(FileServiceImpl.class);
    @Value("${system.scan-file-path}")
    private String filePath;
    public FileServiceImpl(){
        if(!StringUtils.isEmpty(filePath)&&!filePath.endsWith(File.separator)){
            filePath.concat(File.separator);
        }
    }
//    @Autowired
//    private HisVirusMapper hisVirusMapper;
    @Override
    public Record saveFile(MultipartFile file,String sha256) {
        String fileName = file.getOriginalFilename();
        String filePath=this.filePath+fileName;
        File file1=new File(filePath);


        if(!file1.exists()){
            try {
                file1.createNewFile();
            }catch (IOException e){
                log.error("创建文件失败：",e);
            }
        }
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            log.error("保存到目标文件失败：",e);
        }
        String sha2561 = ClamavUtil.getSha256(file1.getAbsolutePath());
        log.info(sha2561);
        if(sha2561.equals(sha256)){
            ClamavCache.push(filePath);
        }else {
            file1.delete();
            return new Record(Record.FAILURE,"文件接收异常");
        }
        return new Record();

    }

    @Override
    public Record saveFiles(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        int num=0;
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
//                return "上传第" + (i++) + "个文件失败";
                log.error("第{}个文件为空",i+1);
                continue;
            }
            String fileName = file.getOriginalFilename();
            File dest = new File(filePath +File.separator+ fileName);
            try {
                file.transferTo(dest);
                num++;
                log.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                log.error("上传第{}个文件失败：{}",i+1, e);
//                return "上传第" + (i++) + "个文件失败";
            }
        }
        if(num==files.size()){
            return new Record();
        }else{
            return new Record(CodeMessage.FAILURE);
        }
    }

    @Override
    public Record checkFile(String fileName) {
        Runtime runtime=Runtime.getRuntime();
        try {
            runtime.exec("clamdscan "+fileName+File.separator+fileName);
        } catch (IOException e) {
           log.error("执行病毒检查失败",e);
           return new Record(CodeMessage.FAILURE);
        }
        return new Record();
    }
}