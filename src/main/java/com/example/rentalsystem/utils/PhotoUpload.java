package com.example.rentalsystem.utils;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthUI;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileprocess")
public class PhotoUpload {
    @PostMapping("/userphotoupload")
    @ResponseBody
    public String uploadUserPhoto(@RequestParam MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            String path = "./src/main/resources/static/images/userphoto";
            String filePath = new File(path).getAbsolutePath();
            System.out.println("ResourcePath = " + filePath);
            String originalName = file.getOriginalFilename();
            String suffixName = originalName.substring(originalName.lastIndexOf("."));
//            String newName = "user" + UserContext.getCurrentUser().getUID() + suffixName;
            String newName = "user" + "123" + suffixName;
            File localFile = new File(new File(filePath).getAbsolutePath() + "/"+ newName);
            System.out.println("FileName" + localFile);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
                System.out.println("上传图片文件+++++++++++");
                System.out.println("文件路径为："+localFile.getPath());
            }
            try{
                file.transferTo(localFile);
                return "1";
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("上传失败");
                return "-1";
            }
        }
        else{
            System.out.println("文件为空");
            return "0";
        }
    }
}
