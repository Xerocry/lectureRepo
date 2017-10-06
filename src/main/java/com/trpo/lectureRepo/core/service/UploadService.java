package com.trpo.lectureRepo.core.service;

import com.trpo.lectureRepo.core.entity.File;
import com.trpo.lectureRepo.core.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by raskia on 9/21/2017.
 */
@Slf4j
@Service
public class UploadService implements IUploadService {

    private final Path rootLocation = Paths.get("C://sr///");

//    @Autowired
//    private DocumentRepository docRepository;

    @Override
    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(rootLocation + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("Uploading file");
        return "redirect:/uploadStatus";
    }

    @Override
    public File findFile(String word) {

//        return docRepository.findOne(word);
        return null;
    }
}
