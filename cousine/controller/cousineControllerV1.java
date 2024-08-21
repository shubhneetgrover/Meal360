package com.meal360.web.cousine.controller;

import ch.qos.logback.core.util.COWArrayList;
import com.meal360.web.cousine.model.CousineModel;
import com.meal360.web.cousine.model.CreateCousine;
import com.meal360.web.cousine.repository.CousineRepositroy;
import com.meal360.web.restaurants.model.Restaurants;
import com.meal360.web.storageService.service.StorageService;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.List;

//@CrossOrigin("*")

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class cousineControllerV1 {

    @Autowired
    private StorageService storageService;

    @Autowired
    private CousineRepositroy cousineRepositroy;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value="/cousine", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> test(){

        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
                .build();

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/cousine")
   // @RequestMapping(value="/cousine", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok( cousineRepositroy.findAll());}

    @PostMapping("/cousine")
    public ResponseEntity<?> createCousine(@RequestBody CreateCousine cousineModel){

        String result = "";

        CousineModel cousineModel1 = null;

        String cousineImageLocation = storageService.getRootDir() + storageService.getCousineStoreDir()
                + cousineModel.getCousineName();

        result = storageService.downloadImageFromUri(cousineModel.getCousineImageURI(), cousineImageLocation);

        if(result == "0"){
            return new ResponseEntity<>(
                    "[]",
                    HttpStatus.INTERNAL_SERVER_ERROR);

        }
        else{
            try{
                cousineModel1 = cousineRepositroy.insert(new CousineModel(cousineModel.getCousineName(),result));
            }catch (MongoWriteException e){
                e.printStackTrace();
            }
        }

        return ResponseEntity.ok(cousineModel1);
    }

    @PutMapping("/cousine/{id}")
    public void updateRestaurant(@PathVariable String id, @RequestBody CousineModel cousineModel){
        cousineRepositroy.save(cousineModel);
    }

    @DeleteMapping("/cousine/{id}")
    public void deleteRestaurants(@PathVariable String id ){
        cousineRepositroy.deleteById(id);
    }




}
