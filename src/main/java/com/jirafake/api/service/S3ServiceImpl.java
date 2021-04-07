package com.jirafake.api.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

public class S3ServiceImpl implements S3Service {
    private String awsS3AudioBucket;
    private AmazonS3 amazonS3;
    private static final Logger logger = LoggerFactory.getLogger(S3ServiceImpl.class);

    @Autowired
    public S3ServiceImpl(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider, String awsS3AudioBucket) {
        this.amazonS3 = AmazonS3ClientBuilder.standard().withCredentials(awsCredentialsProvider)
                .withRegion(awsRegion.getName()).build();
        this.awsS3AudioBucket = awsS3AudioBucket;
    }

    @Async
    public String uploadFileToS3BucketImages(MultipartFile multipartFile, String fileName,
            boolean enablePublicReadAccess) throws FileUploadException {
        if (fileName == null) {
            fileName = multipartFile.getOriginalFilename();
        } else {
            String extension = multipartFile.getOriginalFilename().split("\\.")[1];
            fileName = fileName.concat("." + extension);
        }

        try {
            // creating the file in the server (temporarily)
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.addUserMetadata("cache-control", "max-age=0");

            PutObjectRequest putObjectRequest = new PutObjectRequest(this.awsS3AudioBucket + "/images", fileName,
                    new FileInputStream(file), metadata);

            if (enablePublicReadAccess) {
                putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
            }
            this.amazonS3.putObject(putObjectRequest);
            // removing the file created in the server
            file.delete();
        } catch (IOException | AmazonServiceException ex) {
            logger.error("error [" + ex.getMessage() + "] occurred while uploading [" + fileName + "] ");
            throw new FileUploadException();
        }
        return fileName;
    }

    @Async
    public void deleteFileFromS3Bucket(String fileName) {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(awsS3AudioBucket, fileName));
        } catch (AmazonServiceException ex) {
            logger.error("error [" + ex.getMessage() + "] occurred while removing [" + fileName + "] ");
        }
    }
}
