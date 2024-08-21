package com.meal360.web.menu.controller;

import com.meal360.web.menu.model.Categories;
import com.meal360.web.menu.model.CreateItem;
import com.meal360.web.menu.model.Items;
import com.meal360.web.menu.repository.CategoriesRepository;
import com.meal360.web.menu.repository.ItemsRepository;
import com.meal360.web.restaurants.model.Restaurants;
import com.meal360.web.restaurants.repository.RestaurantsRepository;
import com.meal360.web.storageService.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class menuControllerV1 {


    @Autowired
    private StorageService storageService;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping("/restaurants/{rid}/menu/items")
    public ResponseEntity<?> getAll(@PathVariable("rid") String id){

        Optional<List<Items>> items = itemsRepository.findByRestaurantId(id);
        if (items.get().isEmpty()){
            return new ResponseEntity<>("[]",
                    HttpStatus.OK);

        }
        return ResponseEntity.ok(items.get());

    }

    @PostMapping("/restaurants/{id}/menu/items")
    public ResponseEntity<?> createItem(@RequestBody CreateItem createItem){

        Items items = null;
        String result = "";
        Optional<Restaurants> restaurants = restaurantsRepository.findById(createItem.getRestaurantId());
        if (restaurants.isPresent()){

            String ItemImageLocation = storageService.getRootDir() + storageService.getRestaurantStoreDir() +
                    restaurants.get().getName()+"\\"+ storageService.getItemDir() + createItem.getName();

            result = storageService.downloadImageFromUri(createItem.getImageURI(),ItemImageLocation);
            if(result == "0"){
                return new ResponseEntity<>(
                        "Cannot save menu item",
                        HttpStatus.NOT_ACCEPTABLE);
            }else {

                try {
                    items = itemsRepository.insert(new Items(createItem.getName(), createItem.getDescription(),
                            createItem.getMenuId(), createItem.getRestaurantId(), createItem.getCategoryId(),
                            result.substring(result.indexOf("\\")), createItem.getPrice(), false,
                            null, null, null));
                } catch (Exception e) {
                    e.printStackTrace();
                    return (ResponseEntity<?>) ResponseEntity.status(0);

                }
            }
            return ResponseEntity.ok(items);

        }else{
                return new ResponseEntity<>("[]",
                        HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/restaurants/{rid}/menu/items/{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id")String id,@RequestBody Items item){
        Items item2;
        item2 = itemsRepository.save(item);
        return ResponseEntity.ok(item2);
    }
    @DeleteMapping("/restaurants/{rid}/menu/items/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id")String id){
        itemsRepository.deleteById(id);
        return new ResponseEntity<>(
                "Category Deleted:"+ id,
                HttpStatus.CREATED);
    }

    @GetMapping("/restaurants/{id}/menu/categories")
    public ResponseEntity<?> getAllCategories(@PathVariable("id")String id){

        Optional<List<Categories>> categories = categoriesRepository.findByRestaurantId(id);
        return ResponseEntity.ok(categories.get());
    }

    @PostMapping("/restaurants/{id}/menu/categories")
    public ResponseEntity<?> createCategory(@RequestBody String categoryName,@PathVariable("id")String id){
        Categories categories = null;
        try {
            categories = categoriesRepository.insert(new Categories(categoryName,id));

        }catch (Exception e){
            e.printStackTrace();
            return (ResponseEntity<?>) ResponseEntity.status(0);
        }
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/restaurants/{id}/menu/categories/{cid}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id")String id, @PathVariable("cid")String cid){
        try {

            categoriesRepository.deleteById(cid);;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(
                    "Exception",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(
                "Category Deleted:"+ cid,
                HttpStatus.CREATED);
    }

}
