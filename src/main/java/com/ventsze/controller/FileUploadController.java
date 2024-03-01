package com.ventsze.controller;

import com.ventsze.pojo.Result;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Context;
import javax.swing.text.AbstractDocument;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * packageName com.ventsze.controller
 * @author 章文泽
 * @version JDK 21
 * @className FileUploadController (此处以class为例)
 * @date 2024/3/1
 * @description TODO
 */

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {

        //把文件的内容存到本地磁盘上
        String originalFilename = file.getOriginalFilename();

        //保证文件的名字是唯一的，从而防止文件覆盖
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File("/Users/tombreaver/Developer/SpringBoot/springboot-Event/big-event/src/main/resources/files/"+filename));
        return Result.success("url....");

    }
}