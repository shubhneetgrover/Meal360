package com.meal360.web.restaurantType.controller;

import com.meal360.web.restaurantType.model.CreateRestaurantType;
import com.meal360.web.restaurantType.model.RestaurantType;
import com.meal360.web.restaurantType.repository.RestaurantTypeRepository;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantTypeControllerV1 {

    @Autowired
    private RestaurantTypeRepository restaurantTypeRepository;

    @GetMapping("/restaurantType")
    public List<RestaurantType> getAll(){
        return restaurantTypeRepository.findAll();
    }

    @PostMapping("/restaurantType")
    public ResponseEntity<?> createRestaurantType(@RequestBody CreateRestaurantType restaurantType){

        RestaurantType restaurantType1 = null;

        try{
            restaurantType1 = restaurantTypeRepository.insert(new RestaurantType(restaurantType.getName()));
        }catch (MongoWriteException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(restaurantType1);
    }

    @PutMapping("/restaurantType/{id}")
    public void updateRestaurantTypeName(@PathVariable String id, @RequestBody RestaurantType restaurantType){
        restaurantTypeRepository.save(restaurantType);
    }

    @DeleteMapping("/restaurantType/{id}")
    public void deleteRestaurantTypeById(@PathVariable String id){
        restaurantTypeRepository.deleteById(id);
    }

}
