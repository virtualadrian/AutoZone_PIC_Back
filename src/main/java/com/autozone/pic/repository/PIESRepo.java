package com.autozone.pic.repository;

import com.autozone.pic.model.PIES;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PIESRepo extends CouchbaseRepository<PIES, Integer> {

}
