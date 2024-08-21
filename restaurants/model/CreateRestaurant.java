package com.meal360.web.restaurants.model;

import java.util.List;

public class CreateRestaurant {

    private String name;
    private String ownerTitle;
    private String ownerFirstname;
    private String ownerLastname;

    private List<String> cousineIds;
    private String costForTwo;
    private String safetyMeasureIds;

    private String address;
    private String city;
    private String state;
    private String pincode;
    private String locality;

    private String number;
    private String landLine;

    private String openTime;
    private String closeTime;

    private String email;
    private String username;
    private String password;


    private String profileImage;
    private String profileImageName;
    private List<String> restaurantImages;
    private List<String> restaurantImagesName;
    private String coverImage;
    private String coverImageName;
    private String menuImage;
    private String menuImageName;



   // private String closeDays;

  //  private String contactName;
   // private String userIds;
   // private String menuIds;

  //  private boolean active;
   // private boolean listing;


    public CreateRestaurant(String name, String ownerTitle, String ownerFirstname, String ownerLastname,
                            List<String> cousineIds, String costForTwo, String safetyMeasureIds, String address,
                            String city, String state, String pincode, String locality, String number, String landLine,
                            String openTime, String closeTime, String email, String username, String password,
                            String profileImage, List<String> restaurantImages, String coverImage, String menuImage,
                            String profileImageName, List<String> restaurantImagesName, String coverImageName,
                            String menuImageName) {

        this.name = name;
        this.ownerTitle = ownerTitle;
        this.ownerFirstname = ownerFirstname;
        this.ownerLastname = ownerLastname;
        this.cousineIds = cousineIds;
        this.costForTwo = costForTwo;
        this.safetyMeasureIds = safetyMeasureIds;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.locality = locality;
        this.number = number;
        this.landLine = landLine;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
        this.restaurantImages = restaurantImages;
        this.coverImage = coverImage;
        this.menuImage = menuImage;
        this.profileImageName = profileImageName;
        this.restaurantImagesName = restaurantImagesName;
        this.coverImageName = coverImageName;
        this.menuImageName = menuImageName;

    }

    public String getProfileImageName() {
        return profileImageName;
    }

    public void setProfileImageName(String profileImageName) {
        this.profileImageName = profileImageName;
    }

    public List<String> getRestaurantImages() {
        return restaurantImages;
    }

    public void setRestaurantImages(List<String> restaurantImages) {
        this.restaurantImages = restaurantImages;
    }

    public List<String> getRestaurantImagesName() {
        return restaurantImagesName;
    }

    public void setRestaurantImagesName(List<String> restaurantImagesName) {
        this.restaurantImagesName = restaurantImagesName;
    }

    public String getCoverImageName() {
        return coverImageName;
    }

    public void setCoverImageName(String coverImageName) {
        this.coverImageName = coverImageName;
    }

    public String getMenuImageName() {
        return menuImageName;
    }

    public void setMenuImageName(String menuImageName) {
        this.menuImageName = menuImageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerTitle() {
        return ownerTitle;
    }

    public void setOwnerTitle(String ownerTitle) {
        this.ownerTitle = ownerTitle;
    }

    public String getOwnerFirstname() {
        return ownerFirstname;
    }

    public void setOwnerFirstname(String ownerFirstname) {
        this.ownerFirstname = ownerFirstname;
    }

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public List<String> getCousineIds() {
        return cousineIds;
    }

    public void setCousineIds(List<String> cousineIds) {
        this.cousineIds = cousineIds;
    }

    public String getCostForTwo() {
        return costForTwo;
    }

    public void setCostForTwo(String costForTwo) {
        this.costForTwo = costForTwo;
    }

    public String getSafetyMeasureIds() {
        return safetyMeasureIds;
    }

    public void setSafetyMeasureIds(String safetyMeasureIds) {
        this.safetyMeasureIds = safetyMeasureIds;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }
}
