package com.autozone.pic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
@Setter
@Getter
public class CATALOG {
    @Id
    private Integer id;

    @Field
    private AzDataObject azDataObject;

}