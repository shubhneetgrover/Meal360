package com.meal360.web.storageService.controller;

import com.meal360.web.restaurants.model.CreateRestaurant;
import com.meal360.web.storageService.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StorageServiceControllerV1 {

/*    private StorageService storageService;

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@ModelAttribute ("restaurant_images") MultipartFile multipartFile*//*
                                         @RequestBody CreateRestaurant createRestaurant *//*){
        storageService.store(multipartFile, "images");
        return ResponseEntity.ok(1);




    }*/
/*
    @GetMapping("/image")
    public ResponseEntity<?> getAllImage(){
        *//*storageService.*//*
    }*/

}
