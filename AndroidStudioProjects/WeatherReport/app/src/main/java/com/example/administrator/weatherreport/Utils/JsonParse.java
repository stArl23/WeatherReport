package com.example.administrator.weatherreport.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/8.
 */

public class JsonParse {
    public static Map<String,Object> readWeather(InputStream in){
        Map<String,Object> dataMap=new HashMap<String,Object>();
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode=null;
        try {
            jsonNode=objectMapper.readTree(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(jsonNode!=null){

        }

        return dataMap;
    }
}
