package com.meal360.web.safetyMeasures.controller;

import com.meal360.web.safetyMeasures.model.CreateSafetyMeasures;
import com.meal360.web.safetyMeasures.model.SafetyMeasures;
import com.meal360.web.safetyMeasures.repository.SafetyRepository;
import com.meal360.web.storageService.service.StorageService;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SafetyMeasuresControllerV1 {

    @Autowired
    private StorageService storageService;

    @Autowired
    private SafetyRepository safetyRepository;

    @GetMapping("/safetyMeasures")
    public List<SafetyMeasures> getAll() { return safetyRepository.findAll();}

    @PostMapping("/safetyMeasures")
    public ResponseEntity<?> createSafetyMeasure(@RequestBody CreateSafetyMeasures safetyMeasures){

        boolean result = false;

        SafetyMeasures safetyMeasures1 = null;

        String safetyImageLocation = storageService.getRootDir() + storageService.getSafetyMeasureDir()
                + safetyMeasures.getSafetyMeasureName() + "\\image" + safetyMeasures.getImageName();

        result =  storageService.downloadFileFromUri(safetyMeasures.getImageDir(), safetyImageLocation);
        if(!result){

        }
        else{
            try{
                safetyMeasures1 = safetyRepository.insert(new SafetyMeasures(safetyMeasures.getSafetyMeasureName(),
                        safetyMeasures.getDescription(), safetyImageLocation));

            }catch (MongoWriteException e){
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok(safetyMeasures1);
    }

    @PutMapping("/safetyMeasures/{id}")
    public void updateSafety(@PathVariable String id, @RequestBody SafetyMeasures safetyMeasures){
        safetyRepository.save(safetyMeasures);
    }

    @DeleteMapping("/safetyMeasures/{id}")
    public void deleteMeasureById(@PathVariable String id){
        safetyRepository.deleteById(id);
    }


}
