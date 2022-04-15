package com.autozone.pic.repository;

import com.autozone.pic.model.CATALOG;
import com.autozone.pic.model.PRODUCT;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepo extends CouchbaseRepository<CATALOG, Integer> {

}
