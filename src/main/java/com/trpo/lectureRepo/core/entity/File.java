package com.trpo.lectureRepo.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

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

    @Column
    private String path;

}
