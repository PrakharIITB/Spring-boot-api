package com.example.api.service;

import com.example.api.API.ManufacturerQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class FilterKeywords {

    private static final String[] SCALE = {"small", "large", "medium"};
    private static final String[] MANUFACTURING_PROCESSES = {"moulding", "printing", "casting", "coating"};
    private static final String[] LOCATIONS = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};

    public String getLocation(String query){
        for(String location: LOCATIONS){
            Pattern pattern = Pattern.compile(location, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(query);
            if(matcher.find()) return location;
        }
        return null;
    }

    public String getScale(String query){
        for(String scale: SCALE){
            Pattern pattern = Pattern.compile(scale, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()) return scale+"_scale";
        }
        return null;
    }

    public String getManProcess(String query){
        for(String process: MANUFACTURING_PROCESSES){
            Pattern pattern = Pattern.compile(process, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(query);
            if (matcher.find()){
                if(process.equals("printing")) return "3d_"+process;
                else return process;
            }
        }
        return null;
    }

    public ManufacturerQuery getQuery(String query){
        try {
            ManufacturerQuery finalQuery = new ManufacturerQuery();
            finalQuery.setLocation(getLocation(query));
            finalQuery.setManufacturingProcess(getManProcess(query));
            finalQuery.setNatureOfBusiness(getScale(query));
            return finalQuery;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
