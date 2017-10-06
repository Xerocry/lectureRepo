package com.trpo.lectureRepo.core.service;

import com.trpo.lectureRepo.core.entity.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raskia on 9/21/2017.
 */
public interface IUploadService {
    public String uploadFile(MultipartFile file);

    public File findFile(String word);
}
