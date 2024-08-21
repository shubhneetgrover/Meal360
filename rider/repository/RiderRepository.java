package com.meal360.web.rider.repository;

import com.meal360.web.rider.mdoels.riders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RiderRepository extends MongoRepository<riders, String > {
}
