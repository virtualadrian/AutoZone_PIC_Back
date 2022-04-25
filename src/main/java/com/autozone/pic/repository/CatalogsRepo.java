package com.autozone.pic.repository;
import com.autozone.pic.model.CATALOG;
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
public interface CatalogsRepo extends CouchbaseRepository<CATALOG, String> {
    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThanAndAzDataObject_AzMetaDataObject_SchemaNm(String truncatedDateTime, String productCatalogFitment);
//    public List<CATALOG> findAllNotesByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(String minusDays);
//    public List<CATALOG> findAllNotesByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(String truncatedDateTime);
//    public List<CATALOG> findAllAppsByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(String minusDays);
//    public List<CATALOG> findAllAppsByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(String truncatedDateTime);

//    List<CATALOG> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsContainingAndSchemaNmEquals(String productCatalogNote, String toString);

    //List<CATALOG> findAllAppsByAzDataObject_AzMetaDataObject_EqualsAndLastMaintainTsGreaterThan(String productCatalogFitment, String toString);
}