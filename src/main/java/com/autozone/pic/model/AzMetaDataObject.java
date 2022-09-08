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
public class AzMetaDataObject {

	private String createUserId;

    private String createUserTs;

    private String lastMaintainTs;

    private String lastMaintainUserId;

    private String schemaNm;

    private String schemaVersionTx;

}