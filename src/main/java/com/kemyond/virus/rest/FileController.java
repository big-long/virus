package com.kemyond.virus.rest;

import com.kemyond.virus.common.Record;
import com.kemyond.virus.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zdl
 * @Date 2021/1/4 15:40
 * @Version 1.0
 */
@CrossOrigin
@RestController("/file")
@Api("文件接收")
public class FileController {
    @Autowired
    private FileService fileService;

    @ApiOperation("接收单个文件")
    @PostMapping("/file")
    public Record receiveFile(@RequestParam("file")MultipartFile file,String sha256){
        try {
            return  fileService.saveFile(file,sha256);
        }catch (Exception e){
            return new Record(Record.FAILURE,"接收文件异常",e);
        }

    }

    @ApiOperation("接收多个文件")
    @GetMapping("files")
    public  Record receiveFiles(HttpServletRequest request){
        return fileService.saveFiles(request);

//  String filePath = "/Users/itinypocket/workspace/temp/";
//for (int i = 0; i < files.size(); i++) {
//     MultipartFile file = files.get(i);
//         if (file.isEmpty()) {
//             return "上传第" + (i++) + "个文件失败";
//         }
//        String fileName = file.getOriginalFilename();
//         File dest = new File(filePath + fileName);
//         try {
//            file.transferTo(dest);
//            LOGGER.info("第" + (i + 1) + "个文件上传成功");
//         } catch (IOException e) {
//             LOGGER.error(e.toString(), e);
//             return "上传第" + (i++) + "个文件失败";
//         }
//     }
    }
}
