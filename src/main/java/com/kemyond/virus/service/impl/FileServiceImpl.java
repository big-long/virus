package com.kemyond.virus.service.impl;

import com.kemyond.virus.common.CodeMessage;
import com.kemyond.virus.common.Record;
import com.kemyond.virus.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author zdl
 * @Date 2021/1/4 16:26
 * @Version 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    private  static final Logger log= LoggerFactory.getLogger(FileServiceImpl.class);
    @Value("${system.file-path}")
    private String filePath;
    @Override
    public Record saveFile(MultipartFile file,String sha256) {
        String fileName = file.getOriginalFilename();
        File file1=new File(filePath+File.separator+fileName);
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