package com.meal360.web.menu.repository;

import com.meal360.web.menu.model.menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<menu,String> {
}
