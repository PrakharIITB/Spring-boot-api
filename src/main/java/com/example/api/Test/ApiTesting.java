package com.example.api.Test;

import com.example.api.API.ManufacturerQuery;
import com.example.api.API.controller.ManufacturerController;
import com.example.api.API.model.Manufacturer;
import com.example.api.service.FilterKeywords;
import com.example.api.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class ApiTesting {
//
//    @Autowired
//    private FilterKeywords filterKeywords;
//
//    @Autowired
//    private ManufacturerService manufacturerService;


    public static void main(String[] args){
        String searchQuery = args[0];
        int page = Integer.parseInt(args[1]);
        int size = Integer.parseInt(args[2]);
        FilterKeywords filterKeywords1 = new FilterKeywords();
        ManufacturerService manufacturerService = new ManufacturerService();
        ManufacturerQuery query = filterKeywords1.getQuery(searchQuery);
        Collection<Manufacturer> result = manufacturerService.getManufacturer(query, page, size);
        int i = 1;
        for(Manufacturer m: result){
            System.out.println((i++)+": ");
            System.out.println("Company name -> "+m.getCompanyName());
            System.out.println("Location -> "+m.getLocation());
            System.out.println("Website -> "+m.getWebsite());
            System.out.println("Nature of Business -> "+m.getNatureOfBusiness());
            System.out.println("Manufacturing Process -> "+m.getManufacturingProcesses());
        }
    }


}
