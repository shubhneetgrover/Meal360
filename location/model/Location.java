package com.meal360.web.location.model;

import com.meal360.web.promotions.model.Promotions;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;

public class Location {
    private String type;
    private double[] coordinates;

    public Location(String type, double[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
