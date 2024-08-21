package com.meal360.web.promotions.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "promotions")
public class Promotions {

    private String _id;

    private String name;
    private String description;
    private String imageLocation;
    private String bannerImageLocation;
    private List<String> restaurantsIdsExcluded;
    private List<String> restaurantsIdsIncluded;
    private boolean applyAllRes;
    private Date expiration;
    private double maxDiscount;
    private double discountPercent;
    private List<String> cityIds;
    private boolean active;


    private Date timeStampCreated;
    private Date timeStampUpdated;

    public Promotions(String name, String description, String imageLocation, String bannerImageLocation,
                      List<String> restaurantsIdsExcluded, List<String> restaurantsIdsIncluded,
                      boolean applyAllRes, Date expiration,double discountPercent,double maxDiscount, List<String> cityIds) {
        this.name = name;
        this.description = description;
        this.imageLocation = imageLocation;
        this.bannerImageLocation = bannerImageLocation;
        this.restaurantsIdsExcluded = restaurantsIdsExcluded;
        this.restaurantsIdsIncluded = restaurantsIdsIncluded;
        this.applyAllRes = applyAllRes;
        this.expiration = expiration;
        this.discountPercent = discountPercent;
        this.maxDiscount = maxDiscount;
        this.cityIds = cityIds;
        this.timeStampCreated = new Date();
        this.timeStampUpdated = new Date();
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public List<String> getCityIds() {
        return cityIds;
    }

    public void setCityIds(List<String> cityIds) {
        this.cityIds = cityIds;
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

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getBannerImageLocation() {
        return bannerImageLocation;
    }

    public void setBannerImageLocation(String bannerImageLocation) {
        this.bannerImageLocation = bannerImageLocation;
    }

    public List<String> getRestaurantsIdsExcluded() {
        return restaurantsIdsExcluded;
    }

    public void setRestaurantsIdsExcluded(List<String> restaurantsIdsExcluded) {
        this.restaurantsIdsExcluded = restaurantsIdsExcluded;
    }

    public List<String> getRestaurantsIdsIncluded() {
        return restaurantsIdsIncluded;
    }

    public void setRestaurantsIdsIncluded(List<String> restaurantsIdsIncluded) {
        this.restaurantsIdsIncluded = restaurantsIdsIncluded;
    }

    public boolean isApplyAllRes() {
        return applyAllRes;
    }

    public void setApplyAllRes(boolean applyAllRes) {
        this.applyAllRes = applyAllRes;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Date getTimeStampCreated() {
        return timeStampCreated;
    }

    public void setTimeStampCreated(Date timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
    }

    public Date getTimeStampUpdated() {
        return timeStampUpdated;
    }

    public void setTimeStampUpdated(Date timeStampUpdated) {
        this.timeStampUpdated = timeStampUpdated;
    }
}
