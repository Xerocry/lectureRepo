package com.trpo.lectureRepo.core.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * Created by raskia on 9/21/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "test", type = "pdf")
public class File {
    @Id
    private String id;

}
