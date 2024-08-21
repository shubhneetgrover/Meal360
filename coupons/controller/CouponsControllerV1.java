package com.meal360.web.coupons.controller;

import com.meal360.web.coupons.model.Coupons;
import com.meal360.web.coupons.model.CreateCoupon;
import com.meal360.web.coupons.repository.CouponsRepository;
import com.meal360.web.storageService.service.StorageService;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponsControllerV1 {

    @Autowired
    private StorageService storageService;

    @Autowired
    private CouponsRepository couponsRepository;

    @GetMapping("/coupons")
    public ResponseEntity<?> getAll(){
        List<Coupons> coupons = couponsRepository.findAll();
        return ResponseEntity.ok(coupons);
    }

    @PostMapping("/coupons")
    public ResponseEntity<?> createCoupon(@RequestBody CreateCoupon createCoupon){
        Coupons createCoupon1 = null;
        String result = "";

        String CouponImageLocation = storageService.getRootDir() + storageService.getCouponsDir()
                + createCoupon.getName();

        result = storageService.downloadImageFromUri(createCoupon.getImageURI(), CouponImageLocation);

        if(result == "0"){

            return new ResponseEntity<>("Cannot save menu item", HttpStatus.NOT_ACCEPTABLE);

        }else {

            try {

                createCoupon1 = couponsRepository.insert(new Coupons(createCoupon.getName(), createCoupon.getDescription(),
                        createCoupon.getCouponCode(), CouponImageLocation, createCoupon.getDiscountMaxValue(),
                        createCoupon.getRestaurantIdsExclude(), createCoupon.isApplyAllRes(), createCoupon.getDailyApplyLimit(),
                        createCoupon.getWeeklyApplyLimit(), createCoupon.getMinOrderValue(), null, createCoupon.isOncePerUser(),
                        createCoupon.getExpirationDate(), false));

            } catch (MongoWriteException e) {
                e.printStackTrace();
                return new ResponseEntity<>("",
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return ResponseEntity.ok(createCoupon1);
        }
    }
}
