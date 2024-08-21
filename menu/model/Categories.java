package com.meal360.web.menu.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menuCategories")
public class Categories {

    private String _id;
    private String name;
    private String restaurantId;

    public Categories(String name, String restaurantId) {
        this.name = name;
        this.restaurantId = restaurantId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
}
