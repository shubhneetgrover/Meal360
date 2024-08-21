package com.meal360.web.restaurantType.repository;

import com.meal360.web.restaurantType.model.RestaurantType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantTypeRepository extends MongoRepository<RestaurantType,String > {
}
