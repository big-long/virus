package com.kemyond.virus.service;

import com.kemyond.virus.common.Record;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {
    /**
     * 保存单个文件
     * @param file
     * @return
     */
    Record saveFile(MultipartFile file,String sha256);

    /**
     * 保存多个文件
     * @param request
     * @return
     */
    Record saveFiles(HttpServletRequest request);

    Record checkFile(String fileName);
}
