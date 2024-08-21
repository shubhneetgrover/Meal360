package com.meal360.web.promotions.controller;

import com.meal360.web.promotions.Repository.PromotionsRepository;
import com.meal360.web.promotions.model.CreatePromotion;
import com.meal360.web.promotions.model.Promotions;
import com.meal360.web.restaurants.model.Restaurants;
import com.meal360.web.storageService.service.StorageService;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PromotionControllerV1 {

    @Autowired
    private PromotionsRepository promotionsRepository;

    @Autowired
    private StorageService storageService;




    @GetMapping("/promotions")
    public ResponseEntity<?> getAllPromotions(){
        List<Promotions> promotions = promotionsRepository.findAll();
       return ResponseEntity.ok(promotions);
    }

    @PostMapping("/promotions")
    public ResponseEntity<?> createPromotion(@RequestBody CreatePromotion createPromotion){

        String imageLocation = "";
        String imageLocationBanner = "";

        Promotions promotions = null;


        String ItemImageLocation = storageService.getRootDir() + storageService.getRestaurantStoreDir() +
                storageService.getPromotionsDir() + createPromotion.getName();

        imageLocation = storageService.downloadImageFromUri(createPromotion.getImageURI(),ItemImageLocation);
        if(imageLocation == "0"){
            return new ResponseEntity<>("[]",HttpStatus.NOT_ACCEPTABLE);
        }

/*
        imageLocationBanner = storageService.downloadImageFromUri(createPromotion.getBannerImageURI(),ItemImageLocation);
        if(imageLocationBanner == "0"){
            return new ResponseEntity<>("[]",HttpStatus.NOT_ACCEPTABLE);
        }
*/

        try {
            promotions = promotionsRepository.insert(new Promotions(createPromotion.getName(),createPromotion.getDescription(),
                    imageLocation.substring(imageLocation.indexOf("\\")), null,createPromotion.getRestaurantsIdsExcluded(),
                    createPromotion.getRestaurantsIdsIncluded(),createPromotion.isApplyAllRes(),
                    createPromotion.getExpiration(),createPromotion.getDiscountPercent(),createPromotion.getMaxDiscount(),
                    createPromotion.getCityIds()));
        }catch (MongoWriteException e){
            e.printStackTrace();
            return new ResponseEntity<>("[]",HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(promotions);



    }

    @DeleteMapping("/promotions/{id}")
    public void deletePromotions(@PathVariable String id ){
        promotionsRepository.deleteById(id);
    }

    @PostMapping("/promotions/{id}/active/{flag}")
    public ResponseEntity<?> setPromotionActive(@PathVariable("id") String id, @PathVariable("flag") boolean flag){
        Optional<Promotions> promotions;
        promotions =  promotionsRepository.findById(id);
        if(!promotions.isPresent()){
            return new ResponseEntity<>(
                    "Cannot find promotion with id:"+ id,
                    HttpStatus.NOT_FOUND);
        }
        promotions.get().setActive(flag);
        Promotions promotions1 = promotionsRepository.save(promotions.get());
        return ResponseEntity.ok(promotions1);

    }

    @PostMapping("/promotions/{id}/exclude/{resId}")
    public ResponseEntity<?> addRestaurantToPromotionExcludeList(@PathVariable("id")String id,
                                                                 @PathVariable("resId")String resId){
        Optional<Promotions> promotions;
        Promotions promotions1 = null;
        promotions =  promotionsRepository.findById(id);
        if(!promotions.isPresent()){
            return new ResponseEntity<>(
                    "Cannot find promotion with id:"+ id,
                    HttpStatus.NOT_FOUND);
        }

        List<String> orgExcludedList =  promotions.get().getRestaurantsIdsExcluded();
        if (orgExcludedList == null){
            orgExcludedList = new ArrayList<String>();
        }
        orgExcludedList.add(resId);
        promotions.get().setRestaurantsIdsExcluded(orgExcludedList);;
        try {
            promotions1 =  promotionsRepository.save(promotions.get());
        }catch (MongoWriteException e){

            e.printStackTrace();
            return new ResponseEntity<>(
                    "[]",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(promotions1);
    }

    @PostMapping("/promotions/{id}/excludeRemove/{resId}")
    public ResponseEntity<?> removeRestaurantFromPromotionExcludeList(@PathVariable("id")String id,
                                                                 @PathVariable("resId")String resId){
        Optional<Promotions> promotions;
        Promotions promotions1 = null;
        promotions =  promotionsRepository.findById(id);
        if(!promotions.isPresent()){
            return new ResponseEntity<>(
                    "Cannot find promotion with id:"+ id,
                    HttpStatus.NOT_FOUND);
        }

        List<String> orgExcludedList =  promotions.get().getRestaurantsIdsExcluded();
        if (orgExcludedList == null){
            orgExcludedList = new ArrayList<String>();
        }

        for (int i = 0; i <orgExcludedList.size();i++){
            if(orgExcludedList.get(i).equals(resId)){
                orgExcludedList.remove(i);
                break;
            }
        }
        promotions.get().setRestaurantsIdsExcluded(orgExcludedList);;
        try {
            promotions1 =  promotionsRepository.save(promotions.get());
        }catch (MongoWriteException e){
            e.printStackTrace();
            return new ResponseEntity<>(
                    "[]",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(promotions1);
    }
}
