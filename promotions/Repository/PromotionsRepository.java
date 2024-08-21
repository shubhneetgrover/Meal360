package com.meal360.web.promotions.Repository;

import com.meal360.web.promotions.model.Promotions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface PromotionsRepository extends MongoRepository<Promotions,String> {
   List<Promotions> findByActiveIsTrue();
}
