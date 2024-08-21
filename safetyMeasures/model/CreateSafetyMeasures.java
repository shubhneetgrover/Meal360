package com.meal360.web.safetyMeasures.model;

public class CreateSafetyMeasures {

    private  String safetyMeasureName;
    private String description;
    private String imageName;
    private String imageDir;

    public CreateSafetyMeasures(String safetyMeasureName, String description, String imageName, String imageDir) {
        this.safetyMeasureName = safetyMeasureName;
        this.description = description;
        this.imageName = imageName;
        this.imageDir = imageDir;
    }

    public String getImageDir() {
        return imageDir;
    }

    public void setImageDir(String imageDir) {
        this.imageDir = imageDir;
    }

    public String getSafetyMeasureName() {
        return safetyMeasureName;
    }

    public void setSafetyMeasureName(String safetyMeasureName) {
        this.safetyMeasureName = safetyMeasureName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
