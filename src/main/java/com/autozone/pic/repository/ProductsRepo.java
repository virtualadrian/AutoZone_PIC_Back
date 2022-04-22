package com.autozone.pic.repository;
import com.autozone.pic.model.PRODUCT;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope()
@Collection()
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface ProductsRepo extends CouchbaseRepository<PRODUCT, String> {
    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(String minusDays);
    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(String truncatedDateTime);


    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThanAndAzDataObject_AzMetaDataObject_SchemaNm(String truncatedDateTime, String schemaName);
}
