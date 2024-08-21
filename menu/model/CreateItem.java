package com.meal360.web.menu.model;

public class CreateItem {
    private String name;
    private String description;
    private String menuId;
    private String restaurantId;
    private String categoryId;
    private String imageURI;
    private double price;
    private boolean active;

    public CreateItem(String name, String description, String menuId, String restaurantId,
                      String categoryId,String imageURI, double price, boolean active) {
        this.name = name;
        this.description = description;
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.categoryId = categoryId;
        this.imageURI = imageURI;
        this.price = price;
        this.active = true;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
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
}
