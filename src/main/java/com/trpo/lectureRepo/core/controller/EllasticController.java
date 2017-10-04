package com.trpo.lectureRepo.core.controller;

import com.trpo.lectureRepo.core.entity.File;
import com.trpo.lectureRepo.core.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class EllasticController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/xerocry/";

    @Autowired
    UploadService uploadService;


    @RequestMapping(method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file) {
        uploadService.uploadFile(file);
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public File find(@PathVariable String word) {
        return uploadService.findFile(word);
    }

}
