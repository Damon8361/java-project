package com.example.web_admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 */

@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,   //表单项，用RequestPart

                         //多文件用 MultipartFile[]
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {



        log.info("上船的信息, email= {}, username={}, headerImg={}, photo={}",
                email, username, headerImg.getSize(),photos.length);

    if (!headerImg.isEmpty()){
        //保存到文件服务器，oss服务器
        String originalFilename = headerImg.getOriginalFilename();
        headerImg.transferTo(new File("/Users/tao/Catch/" + originalFilename));
    }


    if (photos.length >0){
        for (MultipartFile photo : photos){
            String originalFilename = photo.getOriginalFilename();
            photo.transferTo(new File("/Users/tao/Catch/" + originalFilename));
        }
    }
        return "main";
    }
}
