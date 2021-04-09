package com.jirafake.api.service;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    
    String uploadFileToS3BucketImages(MultipartFile multipartFile, String fileName, boolean enablePublicReadAccess) throws FileUploadException;

    void deleteFileFromS3Bucket(String fileName);
}
