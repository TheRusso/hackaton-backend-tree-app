package com.it.revolution.trees.app.amazon.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService  {

    String uploadFile(MultipartFile multipartFile);

    void deleteFile(String fileUrl);
}
