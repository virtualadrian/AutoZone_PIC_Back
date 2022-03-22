package com.autozone.pic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Setter
@Getter
public class ACES{
    @Id
    private Integer id;

    private String name;

}