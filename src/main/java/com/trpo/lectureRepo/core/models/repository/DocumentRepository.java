package com.trpo.lectureRepo.core.models.repository;

import com.trpo.lectureRepo.core.models.entity.File;

import java.util.List;

/**
 * Created by raskia on 9/21/2017.
 */
public interface DocumentRepository{
    File findByFirstName(String name);

    List<File> findByLastName(String name);
}