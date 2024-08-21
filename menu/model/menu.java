package com.meal360.web.menu.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("menus")
public class menu {

    private String _id;

    private String restaurantId;
    private String menuImageLocation;
    private String menuImageDir;

}
