package com.autozone.pic.repository;
import com.autozone.pic.model.PRODUCT;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Scope()
@Collection()
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface ProductsRepo extends CouchbaseRepository<PRODUCT, String> {
    public List<PRODUCT> findAllByAzDataObjectAfter(LocalDateTime dateTime);
    public List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_lastMaintainTsGreaterThan(LocalDateTime dateTime);
    public List<PRODUCT> findByAzDataObject_azMetaDataObject_lastMaintainTsEquals(LocalDateTime localDateTime);

    //public List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_lastMaintainTEquals(LocalDateTime minusDays);

    public List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(String minusDays);



    public List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTs(String minusDays);

    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsLessThan(LocalDateTime minusDays);

    List<PRODUCT> findAllByAzDataObjectAzMetaDataObjectLastMaintainTsLessThan(LocalDateTime minusDays);

    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsLike(String minusDays);

    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsEquals(String toString);

    List<PRODUCT> findAllByAzDataObject_AzMetaDataObject_LastMaintainTsContaining(String truncatedDateTime);


//    List<PRODUCT> indAllByAzDataObject_AzMetaDataObject_LastMaintainTsGreaterThan(LocalDateTime minusDays);
}
