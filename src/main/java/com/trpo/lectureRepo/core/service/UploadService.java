package com.trpo.lectureRepo.core.service;

import com.trpo.lectureRepo.core.entity.File;
import com.trpo.lectureRepo.core.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by raskia on 9/21/2017.
 */
@Slf4j
@Service
public class UploadService implements IUploadService {

    private final Path rootLocation = Paths.get("/home/xerocry");

    @Autowired
    private DocumentRepository docRepository;

    @Override
    public void uploadFile(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        log.info("Uploading file");
    }

    @Override
    public File findFile(String word) {
        return docRepository.findOne(word);
    }
}
