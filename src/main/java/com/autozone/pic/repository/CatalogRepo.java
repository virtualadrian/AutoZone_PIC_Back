package com.autozone.pic.repository;

import com.autozone.pic.model.CATALOG;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Scope()
@Collection()
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface CatalogRepo extends CouchbaseRepository<CATALOG, String> {
    public List<CATALOG> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(String minusDays);
    public List<CATALOG> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(String truncatedDateTime);


}