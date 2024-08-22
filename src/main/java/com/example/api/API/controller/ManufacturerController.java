package com.example.api.API.controller;

import com.example.api.API.ExceptionHandling.CustomException;
import com.example.api.API.ExceptionHandling.ErrorResponse;
import com.example.api.API.ManufacturerQuery;
import com.example.api.service.FilterKeywords;
import com.example.api.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManufacturerController {

    private ManufacturerService service;

    @Autowired
    private FilterKeywords filterService;

    @Autowired
    public ManufacturerController(ManufacturerService service){
        this.service = service;
    }

//    private Manufacturer validateData(Manufacturer manufacturer) {
//        String cName = manufacturer.getCompanyName() != null? manufacturer.getCompanyName(): null;
//    }

    @GetMapping("/api/supplier/")
    public ResponseEntity getManufacturer(
            @RequestParam String searchQuery,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size){
//        manufacturer = validateData(manufacturer);
        ManufacturerQuery query = filterService.getQuery(searchQuery);
        if(query.getNatureOfBusiness() == null && query.getLocation() == null && query.getManufacturingProcess() == null){
            throw new CustomException("Invalid input, no search filters present");
        }
        return ResponseEntity.accepted().body(service.getManufacturer(query, page, size));
    }
}
