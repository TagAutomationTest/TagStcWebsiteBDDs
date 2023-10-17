package Pojos;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class DataBinder {

    public void DesrialzeMapper() throws Exception {

       try {
           String currentpath = System.getProperty("user.dir");
           String filepath = currentpath + "/src/test/testdata/Data2.Json";
           ObjectMapper objectMapper = new ObjectMapper();
           WebsiteData obj = objectMapper.readValue(new File(filepath), WebsiteData.class);
       }catch(Exception e){

            throw new Exception(e.getMessage());
        }
    }
}
