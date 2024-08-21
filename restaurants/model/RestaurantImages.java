package com.meal360.web.restaurants.model;

import java.util.List;

public class RestaurantImages {

    private String name;
    private List<String> RestaurantImagesUri;

    public RestaurantImages(String name,List<String> restaurantImagesUri) {
        this.name = name;
        RestaurantImagesUri = restaurantImagesUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRestaurantImagesUri() {
        return RestaurantImagesUri;
    }

    public void setRestaurantImagesUri(List<String> restaurantImagesUri) {
        RestaurantImagesUri = restaurantImagesUri;
    }
}
