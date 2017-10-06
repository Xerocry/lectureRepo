package com.trpo.lectureRepo.core.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Column;


/**
 * Created by raskia on 9/21/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "test", type = "pdf")
public class File {
    @Id
    private String id;

    @Field
    private String path;

    @Field
    private String content;

}
