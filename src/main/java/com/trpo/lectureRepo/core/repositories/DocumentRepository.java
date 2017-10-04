package com.trpo.lectureRepo.core.repositories;

import com.trpo.lectureRepo.core.entity.File;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * Created by raskia on 9/21/2017.
 */
public interface DocumentRepository extends ElasticsearchCrudRepository<File, String> {
    File findByFirstName(String name);

    List<File> findByLastName(String name);
}