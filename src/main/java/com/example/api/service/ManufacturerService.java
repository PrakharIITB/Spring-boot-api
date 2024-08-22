package com.example.api.service;

import com.example.api.API.ManufacturerQuery;
import com.example.api.API.model.Manufacturer;
import com.example.api.ManufacturerDataGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerService {

    List<Manufacturer> manufacturerList;

    public ManufacturerService(){
        this.manufacturerList = ManufacturerDataGenerator.generateManufacturers();
    }

    public Collection<Manufacturer> getManufacturer(ManufacturerQuery query, int page, int size) {
        List<Manufacturer> res = new ArrayList<>();
        try {
            return manufacturerList.stream()
                    .filter(m -> query.getLocation() == null || query.getLocation().equals(m.getLocation()))
                    .filter(m -> query.getManufacturingProcess() == null || query.getManufacturingProcess().equals(m.getManufacturingProcesses()))
                    .filter(m -> query.getNatureOfBusiness() == null || query.getNatureOfBusiness().equals(m.getNatureOfBusiness()))
                    .skip((page - 1) *size)
                    .limit(size)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
