package com.grinyov.spring.rest_client.persistence;

import com.grinyov.spring.rest_client.model.StackOverflowWebsite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by grinyov
 */
@Repository
public interface StackOverflowWebsiteRepository extends MongoRepository<StackOverflowWebsite, String> {

    List<StackOverflowWebsite> findByWebsite(String website);

//    public List<StackOverflowWebsite> findAll() {
//        return mongoTemplate.findAll(StackOverflowWebsite.class);
//    }
}
