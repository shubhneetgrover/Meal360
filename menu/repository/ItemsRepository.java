package com.meal360.web.menu.repository;

import com.meal360.web.menu.model.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ItemsRepository extends MongoRepository<Items, String > {

    Optional<List<Items>> findByRestaurantId(String userName);
    Optional<List<Items>> findByMenuId(String userName);

}
