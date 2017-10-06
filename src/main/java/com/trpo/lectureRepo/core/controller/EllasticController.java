package com.trpo.lectureRepo.core.controller;

import com.trpo.lectureRepo.core.models.entity.File;
import com.trpo.lectureRepo.core.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class EllasticController {

    @Autowired
    private ElasticsearchTemplate template;

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/xerocry/";

    @Autowired
    UploadService uploadService;

    @RequestMapping(method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            uploadService.uploadFile(file);
        } catch (Exception e) {
        }
        return "upload";
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public File find(@PathVariable String word) {
        return uploadService.findFile(word);
    }

}
