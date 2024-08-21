package com.meal360.web.restaurants.controller;

import com.meal360.web.promotions.Repository.PromotionsRepository;
import com.meal360.web.promotions.controller.PromotionControllerV1;
import com.meal360.web.promotions.model.Promotions;
import com.meal360.web.restaurantType.model.RestaurantType;
import com.meal360.web.restaurants.model.CreateRestaurant;
import com.meal360.web.restaurants.model.RestaurantImages;
import com.meal360.web.restaurants.model.Restaurants;
import com.meal360.web.restaurants.repository.RestaurantsRepository;
import com.meal360.web.storageService.service.StorageService;
import com.mongodb.MongoWriteException;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantsControllerV1 {

    @Autowired
    private StorageService storageService;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    @Autowired
    private PromotionsRepository promotionsRepository;

/*
    //@CrossOrigin(origins = "*", allowedHeaders = "*")
    //@GetMapping("/restaurants")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value="/restaurants", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> preFlight(){
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS, HttpMethod.DELETE)
                .build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value="/restaurants/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> preFlight2(){
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS, HttpMethod.DELETE)
                .build();
    }
*/

    @GetMapping("/restaurants")
    public List<Restaurants> getAll(){ return restaurantsRepository.findAll();}

/*    @PostMapping("/restaurants")
    public ResponseEntity<?> createRestaurant(@RequestParam("name") String name,@RequestParam("address")String address,
                                              @RequestParam("profile_photo") String profilePhoto,
                                              @RequestParam("restaurant_images") MultipartFile[] multipartFile,
                                              @RequestParam("city")String city, @RequestParam("pincode")String pincode,
                                              @RequestParam("state")String state,
                                              @RequestParam("contactName")String contactName,
                                              @RequestParam("number")String number, @RequestParam("email")String email,
                                              @RequestParam("username")String username,
                                              @RequestParam("password") String password) {


        Restaurants restaurant = null;

        boolean result = false;
        try {

            String restImage = name + "image1";
            String restImage2 = name + "image2";

//            result = storageService.store(profilePhoto, )/

//            result = storageService.storeUrl(mult ipartFile, restImage);

            String profileImageLocation = storageService.getRootDir()+ storageService.getRestaurantStoreDir()
                    +name+"\\"+ "profilePhoto";

            if(result) {
                restaurant = restaurantsRepository.insert(new Restaurants(name, address, city, state, pincode, contactName, number, email,
                        false, username, password, profileImageLocation));
            }
            else {
                //return (ResponseEntity<?>) ResponseEntity.badRequest();
            }
*//*             restaurant = restaurantsRepository.insert(new Restaurants(name, createRestaurant.getAddress(),
                     createRestaurant.getCity(), createRestaurant.getState(), createRestaurant.getPincode(), createRestaurant.getContactName(),
                    createRestaurant.getNumber(), createRestaurant.getEmail(), false, createRestaurant.getUsername(),
                    createRestaurant.getPassword()));*//*
        }catch (MongoWriteException e) {

        }
        return ResponseEntity.ok(restaurant);
    }*/

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/restaurants")
    public ResponseEntity<?> createRestaurant(@RequestBody CreateRestaurant createRestaurant){

        String res = null;
        int resImagesSize = 0;
        boolean result = false;
        String resCover = null;
        String resProfile = null;
        Restaurants restaurants = null;
        List<String> resImageLocations = new ArrayList<String>();


        String imageLocation = storageService.getRootDir()+ storageService.getRestaurantStoreDir()
                +createRestaurant.getName();
        resProfile = storageService.downloadImageFromUri(createRestaurant.getProfileImage(), imageLocation);
        if (resProfile == "0"){
            return new ResponseEntity<>("[]",HttpStatus.BAD_REQUEST);
        }

        resCover = storageService.downloadImageFromUri(createRestaurant.getCoverImage(), imageLocation);
        if (resCover == "0"){
            return new ResponseEntity<>("[]",HttpStatus.BAD_REQUEST);
        }

        if (createRestaurant.getRestaurantImages() == null){
            return new ResponseEntity<>("[]",HttpStatus.BAD_REQUEST);
        }else {

            resImagesSize = createRestaurant.getRestaurantImages().size();
            resImageLocations.clear();

            for (int i = 0; i<resImagesSize; i++){
                res = storageService.downloadImageFromUri(createRestaurant.getRestaurantImages().get(i),
                        imageLocation);
                if (res == "0"){
                    return new ResponseEntity<>("[]]",HttpStatus.BAD_REQUEST);
                }else  {
                    resImageLocations.add(res.substring (res.indexOf("\\")));
                }
            }

        }


        try {

            restaurants = restaurantsRepository.insert(new Restaurants(createRestaurant.getName(), createRestaurant.getOwnerTitle(),
                    createRestaurant.getOwnerFirstname(),createRestaurant.getOwnerLastname(), createRestaurant.getCousineIds(),
                    createRestaurant.getCostForTwo(),createRestaurant.getAddress(),createRestaurant.getCity(),createRestaurant.getState(),
                    createRestaurant.getPincode(),createRestaurant.getLocality(),createRestaurant.getNumber(),createRestaurant.getLandLine(),
                    createRestaurant.getOpenTime(),createRestaurant.getCloseTime(),createRestaurant.getEmail(),createRestaurant.getUsername(),
                    createRestaurant.getPassword(),resProfile.substring (resProfile.indexOf("\\")),resImageLocations,
                    resCover.substring(resCover.indexOf("\\")),null));

        }catch (MongoWriteException e) {
            e.printStackTrace();
            return new ResponseEntity<>("[]",HttpStatus.NOT_ACCEPTABLE) ;

        }
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable("id") String id){

         Optional<Restaurants> restaurants = restaurantsRepository.findById(id);
         if(restaurants != null){
             return ResponseEntity.ok(restaurants);
         }else {
             return (ResponseEntity<?>) ResponseEntity.notFound();
         }
    }

    @PutMapping("/restaurants/{id}")
    public void updateRestaurant(@PathVariable String id, @RequestBody Restaurants restaurants){
        restaurantsRepository.save(restaurants);
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurants(@PathVariable String id ){
        restaurantsRepository.deleteById(id);
    }

    @PostMapping("/restaurants/{id}/active/{flag}")
    public ResponseEntity<?> setRestaurantActiveListing(@PathVariable("id") String id, @PathVariable("flag") boolean flag){
        Optional<Restaurants> restaurants;
        restaurants =  restaurantsRepository.findById(id);
        if(restaurants == null){
            return new ResponseEntity<>(
                    "Cannot find restaurant with id:"+ id,
                    HttpStatus.NOT_FOUND);
        }
        restaurants.get().setActive(flag);
        Restaurants restaurants1 = restaurantsRepository.save(restaurants.get());
        return ResponseEntity.ok(restaurants1);

    }

    @GetMapping("/restaurants/search/{resName}")
    public ResponseEntity<?> searchRestaurants(@PathVariable("resName") String resName){
        List<Restaurants> restaurants = restaurantsRepository.query("{\"name\":\"" +resName +"\"}");
        return  ResponseEntity.ok(restaurants);
    }

    @PostMapping("/restaurants/checkUsername/{username}")
    public ResponseEntity<?> checkUsername(@PathVariable("username") String username){
        Optional<Restaurants> restaurants = restaurantsRepository.findByUsername(username);
        if(restaurants.isPresent()){
            return new ResponseEntity<>(
                    "find restaurant with username:" + username,
                    HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(
                    "No restaurant with username:" + username,
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/restaurants/{id}/addImage")
    public ResponseEntity<?> addRestaurantImage(@RequestBody RestaurantImages restaurantImages,
                                                @PathVariable("id")String id){

        String res = "";
        int resImagesSize = 0;
        List<String> resImages;
        Restaurants restaurants1;

        Optional<Restaurants> restaurants = restaurantsRepository.findById(id);
        if(restaurants.isPresent()){
            resImages = restaurants.get().getRestaurantImages();
        }else {
            return new ResponseEntity<>(
                    "Restaurant cant be found with id"+ id,
                    HttpStatus.BAD_REQUEST);
        }

        String resImageLocation = storageService.getRootDir()+ storageService.getRestaurantStoreDir()
                +restaurantImages.getName();

        if (restaurantImages.getRestaurantImagesUri() == null){
            return new ResponseEntity<>(
                    "Restaurant Images cannot be null",
                    HttpStatus.BAD_REQUEST);
        }else {
            resImagesSize = restaurantImages.getRestaurantImagesUri().size();
        }
        for (int i = 0; i<resImagesSize; i++){
            res = storageService.downloadImageFromUri(restaurantImages.getRestaurantImagesUri().get(i),
                    resImageLocation);
            if (res == "0"){
                return new ResponseEntity<>(
                        "Restaurant Images cannot be saved",
                        HttpStatus.BAD_REQUEST);
            }else  {
                resImages.add(res.substring (res.indexOf("\\")));
            }
        }
        try {
            restaurants1 = restaurantsRepository.save(restaurants.get());

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(
                    "Restaurant Images cannot be saved",
                    HttpStatus.EXPECTATION_FAILED);
        }

        return ResponseEntity.ok(restaurants1);



    }


    @GetMapping("/restaurants/{id}/promotions")
    public ResponseEntity<?> getAllActivePromotionsByRestaurantId(@PathVariable("id")String id){
        Optional<Restaurants> restaurants = restaurantsRepository.findById(id);
        if(!restaurants.isPresent()){
            return new ResponseEntity<>(
                    "[]:",
                    HttpStatus.OK);
        }

        boolean excluded = false;
        List<String> activePromotionIds = new ArrayList<String>();
        List<Promotions> promotions = promotionsRepository.findByActiveIsTrue();
        if(promotions.isEmpty()){
            return new ResponseEntity<>(
                    "[]",
                    HttpStatus.OK);
        }

        for(int i =  0;i<promotions.size();i++){
            List<String>ExcludedResList =  promotions.get(i).getRestaurantsIdsExcluded();

            excluded = false;
            if(ExcludedResList != null) {

                for (int j = 0; j < ExcludedResList.size(); j++) {
                    if ((ExcludedResList.get(j).equals(restaurants.get().get_id()))) {
                        excluded = true;
                        break;
                    }
                }
            }
            if(excluded == false){
                List<String>cityIds=  promotions.get(i).getCityIds();
                boolean activeInCity = false;
                if(cityIds!= null){
                    for(int k =0;k<cityIds.size();k++){
                        if(cityIds.get(k).equals(restaurants.get().getCity())){
                            activeInCity = true;
                            activePromotionIds.add(promotions.get(i).get_id());
                            continue;
                        }
                    }
                }
            }

        }

        return ResponseEntity.ok(activePromotionIds);

    }
}
