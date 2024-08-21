package com.meal360.web.menu.repository;

import com.meal360.web.menu.model.Categories;
import com.meal360.web.menu.model.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends MongoRepository<Categories, String > {
    Optional<List<Categories>> findByRestaurantId(String userName);

}
