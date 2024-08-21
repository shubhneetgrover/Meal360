package com.meal360.web.coupons.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Coupons")
public class Coupons {

    private String _id;

    private String name;
    private String description;
    private String couponCode;
    private String imageLocation;
    private String discountMaxValue;
    private List<String> restaurantIdsExclude;
    private boolean applyAllRes;
    private String dailyApplyLimit;
    private String weeklyApplyLimit;
    private int minOrderValue;
    private List<String> userIds;
    private boolean oncePerUser;
    private Date expirationDate;

    public Coupons(String name, String description, String couponCode, String imageLocation,
                   String discountMaxValue, List<String> restaurantIdsExclude, boolean applyAllRes,
                   String dailyApplyLimit, String weeklyApplyLimit, int minOrderValue,
                   List<String> userIds, boolean oncePerUser, Date expirationDate, boolean active) {
        this.name = name;
        this.description = description;
        this.couponCode = couponCode;
        this.imageLocation = imageLocation;
        this.discountMaxValue = discountMaxValue;
        this.restaurantIdsExclude = restaurantIdsExclude;
        this.applyAllRes = applyAllRes;
        this.dailyApplyLimit = dailyApplyLimit;
        this.weeklyApplyLimit = weeklyApplyLimit;
        this.minOrderValue = minOrderValue;
        this.userIds = userIds;
        this.oncePerUser = oncePerUser;
        this.expirationDate = expirationDate;
        this.active = active;
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

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getDiscountMaxValue() {
        return discountMaxValue;
    }

    public void setDiscountMaxValue(String discountMaxValue) {
        this.discountMaxValue = discountMaxValue;
    }

    public List<String> getRestaurantIdsExclude() {
        return restaurantIdsExclude;
    }

    public void setRestaurantIdsExclude(List<String> restaurantIdsExclude) {
        this.restaurantIdsExclude = restaurantIdsExclude;
    }

    public boolean isApplyAllRes() {
        return applyAllRes;
    }

    public void setApplyAllRes(boolean applyAllRes) {
        this.applyAllRes = applyAllRes;
    }

    public String getDailyApplyLimit() {
        return dailyApplyLimit;
    }

    public void setDailyApplyLimit(String dailyApplyLimit) {
        this.dailyApplyLimit = dailyApplyLimit;
    }

    public String getWeeklyApplyLimit() {
        return weeklyApplyLimit;
    }

    public void setWeeklyApplyLimit(String weeklyApplyLimit) {
        this.weeklyApplyLimit = weeklyApplyLimit;
    }

    public int getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(int minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public boolean isOncePerUser() {
        return oncePerUser;
    }

    public void setOncePerUser(boolean oncePerUser) {
        this.oncePerUser = oncePerUser;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;

}
