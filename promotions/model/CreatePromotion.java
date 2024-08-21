package com.meal360.web.promotions.model;

import java.util.Date;
import java.util.List;

public class CreatePromotion {

    private String name;
    private String description;
    private String imageURI;
    private String bannerImageURI;
    private List<String> restaurantsIdsExcluded;
    private List<String> restaurantsIdsIncluded;
    private boolean applyAllRes;
    private Date expiration;
    private double maxDiscount;
    private double discountPercent;
    private List<String> cityIds;

    public CreatePromotion(String name, String description, String imageURI, String bannerImageURI,
                           List<String> restaurantsIdsExcluded, List<String> restaurantsIdsIncluded,
                           boolean applyAllRes, Date expiration, double maxDiscount, double discountPercent,
                           List<String> cityIds) {
        this.name = name;
        this.description = description;
        this.imageURI = imageURI;
        this.bannerImageURI = bannerImageURI;
        this.restaurantsIdsExcluded = restaurantsIdsExcluded;
        this.restaurantsIdsIncluded = restaurantsIdsIncluded;
        this.applyAllRes = applyAllRes;
        this.expiration = expiration;
        this.maxDiscount = maxDiscount;
        this.discountPercent = discountPercent;
        this.cityIds = cityIds;
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

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getBannerImageURI() {
        return bannerImageURI;
    }

    public void setBannerImageURI(String bannerImageURI) {
        this.bannerImageURI = bannerImageURI;
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
}
