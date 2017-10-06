package com.trpo.lectureRepo.core.models.repository;

import com.trpo.lectureRepo.core.models.entity.File;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticSearchRepository extends ElasticsearchRepository<File, Long> {
    List<File> findEmployeesByName(String word);
    List<File> findEmployeesByWord(String word);}
