package com.autozone.pic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AzMetaDataObject {

	private String createUserId;

    private LocalDateTime createUserTs;

    private LocalDateTime lastMaintainTs;

    private String lastMaintainUserId;

    private String schemaNm;

    private String schemaVersionTx;

}