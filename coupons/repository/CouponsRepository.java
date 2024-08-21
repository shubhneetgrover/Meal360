package com.meal360.web.coupons.repository;

import com.meal360.web.coupons.model.Coupons;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponsRepository extends MongoRepository<Coupons, String> {
}
