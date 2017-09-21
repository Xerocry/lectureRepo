package com.trpo.lectureRepo.core.repositories;

import com.trpo.lectureRepo.core.entity.jpa.File;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by raskia on 9/21/2017.
 */
public interface DocumentRepository extends MongoRepository<File, String> {
    File findByFirstName(String name);

    List<File> findByLastName(String name);
}