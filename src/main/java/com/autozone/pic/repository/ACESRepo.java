package com.autozone.pic.repository;

import com.autozone.pic.model.ACES;
import com.autozone.pic.model.PIES;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ACESRepo extends CouchbaseRepository<ACES, Integer> {

}
