package com.meal360.web.restaurants.repository;

import com.meal360.web.restaurants.model.Restaurants;
import com.mongodb.client.MongoCollection;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface RestaurantsRepository extends MongoRepository<Restaurants, String> {
  //  public Optional<Restaurants> findByUsernameLikeAndDescriptionLike(String username, String description);

    //"{name:{regex:$value}}"

    List<Restaurants> findByNameLike(String name);

    Optional<Restaurants> findByUsername(String username);


    @Query(value = "{ $or: [ { 'name' : {$regex:?0,$options:'i'} }, { 'city' : {$regex:?0,$options:'i'} } ] }")
    List<Restaurants> query(String query);

    @Query(value = "{ $or: [ { 'name' : {$regex:?0,$options:'i'} }, { 'description' : {$regex:?0,$options:'i'} } ," +
            " { 'city' : {$regex:?0,$options:'i'} }] }")
    List<Restaurants> query2(String query);

}
