package com.autozone.pic.repository;

import com.autozone.pic.model.PIES;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;


@Repository
@Scope()
@Collection()
@ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
public interface PIESRepo extends CouchbaseRepository<PIES, String> {

}
