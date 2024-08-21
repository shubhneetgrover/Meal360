package com.meal360.web.restaurantType.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("restaurantType")
public class RestaurantType {

    public String _id;
    public String name;

    public RestaurantType(String name) {
        this.name = name;
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
}
