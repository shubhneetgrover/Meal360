package com.meal360.web.safetyMeasures.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("safetyMeasure")
public class SafetyMeasures {

    private String _id;

    @NotNull
    private String safetyName;
    private String description;
    private String image;

    public SafetyMeasures(String safetyName, String description, String image) {
        this.safetyName = safetyName;
        this.description = description;
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSafetyName() {
        return safetyName;
    }

    public void setSafetyName(String safetyName) {
        this.safetyName = safetyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
