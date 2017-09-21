package com.trpo.lectureRepo.core.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
 * Created by raskia on 9/21/2017.
 */
@Slf4j
@Service
public class UploadService implements IUploadService {

    @Override
    public void uploadFile() {
        log.info("Uploading file");
    }
}
