package com.example.api.API;

import com.example.api.API.model.Manufacturer;

public class ManufacturerQuery {
    String location;
    String natureOfBusiness;
    String manufacturingProcess;

    public ManufacturerQuery(String location, String natureOfBusiness, String manufacturingProcess, String companyName, String query){
        this.location = location;
        this.manufacturingProcess = manufacturingProcess;
        this.natureOfBusiness = natureOfBusiness;
    }

    public ManufacturerQuery(){ }

    public String getLocation() {
        return location;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getManufacturingProcess() {
        return manufacturingProcess;
    }

    public void setManufacturingProcess(String manufacturingProcess) {
        this.manufacturingProcess = manufacturingProcess;
    }


    public void setLocation(String location) {
        this.location = location;
    }
}
