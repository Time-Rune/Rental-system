package com.example.rentalsystem.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/fileprocess")
public class PhotoUpload {
    @GetMapping("/userphotoupload")
    public void uploadUserPhoto(@RequestParam MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            String filePath = "/static/images/userphoto";
            File uploadDir = new File(filePath);
            String originalName = file.getOriginalFilename();
            String suffixName = originalName.substring(originalName.lastIndexOf("."));
            String newName = "user" + Integer.toString(UserContext.getCurrentUser().getUID()) + suffixName;
            File localFile = new File(filePath + "/"+ newName);
//            try{
//                file.transferTo(filePath);
//
//            }
        }
    }
}
