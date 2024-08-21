package com.meal360.web.restaurants.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "restaurants")
public class Restaurants {
    private String _id;


    @NotNull
    private String name;

    @NotNull
    private String ownerTitle;

    @NotNull
    private String ownerFirstname;

    @NotNull
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
    private String closeDays;

    private String contactName;

    private String userIds;
    private String menuIds;

    @NotNull
    private Date timeStampCreated;

    @Indexed(unique=true)
    private String email;
    private boolean active;
    private boolean listing;


    @Indexed(unique=true)
    private String username;
    private String password;


    private String profileImage;
    private List<String> restaurantImages;
    private String coverImage;
    private String menuImage;

    private Date timeStampLastUpdated;

/*
    public Restaurants(String name, String address, String city, String state,
                       String pincode, String contactName, String number, String email,
                       boolean active, String userName, String password, String profileImage, String menuImage) {

        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.contactName = contactName;
        this.number = number;
        this.email = email;
        this.username = userName;
        this.password = password;
        this.active = active;
        this.timeStampCreated = new Date();
        this.profileImage = profileImage;
        this.menuImage = menuImage;
    }*/

    public Restaurants(String name, String ownerTitle, String ownerFirstname, String ownerLastname,
                       List<String> cousineIds, String costForTwo, String address, String city, String state,
                       String pincode, String locality, String number, String landLine, String openTime,
                       String closeTime, String email, String username, String password, String profileImage,
                       List<String> restaurantImages, String coverImage, String menuImage) {
        this.name = name;
        this.ownerTitle = ownerTitle;
        this.ownerFirstname = ownerFirstname;
        this.ownerLastname = ownerLastname;
        this.cousineIds = cousineIds;
        this.costForTwo = costForTwo;
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
        this.timeStampCreated = new Date();
        this.timeStampLastUpdated = new Date();
        this.menuImage = menuImage;

    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
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

    public String getCloseDays() {
        return closeDays;
    }

    public void setCloseDays(String closeDays) {
        this.closeDays = closeDays;
    }

    public Date getTimeStampCreated() {
        return timeStampCreated;
    }

    @NotNull
    public void setTimeStampCreated(Date timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
    }

    public boolean isListing() {
        return listing;
    }

    public void setListing(boolean listing) {
        this.listing = listing;
    }

    public List<String> getRestaurantImages() {
        return restaurantImages;
    }

    public void setRestaurantImages(List<String> restaurantImages) {
        this.restaurantImages = restaurantImages;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Date getTimeStampLastUpdated() {
        return timeStampLastUpdated;
    }

    public void setTimeStampLastUpdated(Date timeStampLastUpdated) {
        this.timeStampLastUpdated = timeStampLastUpdated;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Date getTimeStamp() {

        return timeStampCreated;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStampCreated = timeStamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getUserIds() {
        //TODO: add user by role
        return null;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getMenuIds() {
        //TODO: should return menuids;
        return null;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
