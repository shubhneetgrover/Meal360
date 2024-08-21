package com.meal360.web.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class AdminControllerV1 {

    @GetMapping("/v1/admin")
    private String admin(){ return "<h1>Admin<h1>";}

    @GetMapping("/v2/admin")
    private int admin2(){
        int intArray[] = new int[20];
        System.out.print("GfG2");

        return intArray[21];}
}
