package com.autozone.pic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Document;


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class AzDataObject {

    private AzMetaDataObject azMetaDataObject;
    private PrimaryElementsObject primaryElementsObject;

}