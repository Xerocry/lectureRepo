package com.trpo.lectureRepo.core.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.trpo.lectureRepo.domain")
public class ElasticsearchConfiguration {
}
