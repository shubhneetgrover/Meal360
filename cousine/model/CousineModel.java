package com.meal360.web.cousine.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cousine")
public class CousineModel {

    private String _id;

    private String cousineImage;

    @NotNull
    private String cousineName;

    public CousineModel(String cousineImage, String cousineName) {
        this.cousineImage = cousineImage;
        this.cousineName = cousineName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCousineImage() {
        return cousineImage;
    }

    public void setCousineImage(String cousineImage) {
        this.cousineImage = cousineImage;
    }

    public String getCousineName() {
        return cousineName;
    }

    public void setCousineName(String cousineName) {
        this.cousineName = cousineName;
    }
}
