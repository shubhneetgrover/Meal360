package com.meal360.web.menu.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "items")
public class Items {

    private String _id;
    private String name;
    private String description;
    private String menuId;
    private String restaurantId;
    private String categoryId;
    private String imageLocation;
    private double price;
    private boolean active;
    private Map<String, Double> customizations;
    private Map<String, Double> size;
    private Map<String,Double> addOns;

    public Items(String name, String description, String menuId, String restaurantId, String categoryId,
                 String imageLocation, double price, boolean active, Map<String, Double> customizations,
                 Map<String, Double> size, Map<String, Double> addOns) {
        this.name = name;
        this.description = description;
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.categoryId = categoryId;
        this.imageLocation = imageLocation;
        this.price = price;
        this.active = active;
        this.customizations = customizations;
        this.size = size;
        this.addOns = addOns;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, Double> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(Map<String, Double> customizations) {
        this.customizations = customizations;
    }

    public Map<String, Double> getSize() {
        return size;
    }

    public void setSize(Map<String, Double> size) {
        this.size = size;
    }

    public Map<String, Double> getAddOns() {
        return addOns;
    }

    public void setAddOns(Map<String, Double> addOns) {
        this.addOns = addOns;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
