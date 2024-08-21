package com.meal360.web.rider.controller;

import com.meal360.web.location.model.Location;
import com.meal360.web.rider.mdoels.CreateRider;
import com.meal360.web.rider.mdoels.riders;
import com.meal360.web.rider.repository.RiderRepository;
import com.meal360.web.storageService.service.StorageService;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RiderControllerV1 {

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private StorageService storageService;

    @GetMapping("/rider")
    public List<riders> getAll(){return riderRepository.findAll();}

    @PostMapping("/rider")
    public ResponseEntity<?> createRider(@RequestBody CreateRider createRider){
        boolean result = false;

        riders createRider1 = null;

       /* String riderProfileImageLocation = storageService.getRootDir() + storageService.getRiderDir()
                + createRider.getUsername() + "\\image" + createRider.getPhotoName();

        String riderUIDImageLocation = storageService.getRootDir() + storageService.getRiderDir()
                + createRider.getUsername() + "\\UID" + createRider.getUidNumberImagename();

        String riderLicenceImageLocation = storageService.getRootDir() + storageService.getRiderDir()
                + createRider.getUsername() + "\\Licence" + createRider.getLicenseNumberImagename();

        String riderRCImageLocation = storageService.getRootDir() + storageService.getRiderDir()
                + createRider.getUsername() + "\\RC" + createRider.getVehicleRcImagename();

        result = storageService.downloadFileFromUri(createRider.getphotoUri(), riderProfileImageLocation);
        if(!result){
            return (ResponseEntity<?>) ResponseEntity.status(0);

        }

        result = storageService.downloadFileFromUri(createRider.getUidNumberImageUri(), riderUIDImageLocation);
        if(!result){
            return (ResponseEntity<?>) ResponseEntity.status(0);

        }
        result = storageService.downloadFileFromUri(createRider.getLicenseNumberImageUri(), riderLicenceImageLocation);
        if(!result){
            return (ResponseEntity<?>) ResponseEntity.status(0);

        }
        result = storageService.downloadFileFromUri(createRider.getVehicleRcImageUri(), riderRCImageLocation);
        if(!result){
            return (ResponseEntity<?>) ResponseEntity.status(0);

        }else {*/
            try {
                createRider1 = riderRepository.insert(new riders(createRider.getTitle(),createRider.getFirstname(),
                        createRider.getLastname(),null, createRider.getUidNumber(),null,
                                createRider.getLicenseNumber(),null,createRider.getVehicleType(),
                        createRider.getVehicleNumber(), null, createRider.getEmail(), createRider.getNumber(),
                        createRider.getUsername(), createRider.getPassword(), createRider.getAddress(), createRider.getCity(),
                        createRider.getState(),createRider.getPincode(), createRider.getLocality()));
            }catch (MongoWriteException e){
                e.printStackTrace();
            }
        //}


        return ResponseEntity.ok(createRider1);

    }

    @PutMapping("/rider/{id}")
    public ResponseEntity<?> updateRiderById(@PathVariable("id") String id, @RequestBody riders rider){
        try {
            riderRepository.save(rider);
        }catch (MongoException e){
            e.printStackTrace();
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }

        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @DeleteMapping("/riders/{id}")
    public ResponseEntity<?> deleteRiderById(@PathVariable("id") String id){
        try {
            riderRepository.deleteById(id);
        }catch (MongoException e){
            return (ResponseEntity<?>) ResponseEntity.status(0);
        }
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @PostMapping("/rider/{id}/location")
    public ResponseEntity<?> updateLocation(@PathVariable("id")String id, @RequestBody Location location){
        Optional<riders> riders = riderRepository.findById(id);
        if(!riders.isPresent()){
            return new ResponseEntity<>("[]", HttpStatus.NOT_FOUND);
        }
        riders riders1 =null;
        riders.get().setLocation(location);
        try {
            riders1 = riderRepository.save(riders.get());

        }catch (MongoWriteException e){
            e.printStackTrace();
            return new ResponseEntity<>("[]", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(riders1);


    }

}
