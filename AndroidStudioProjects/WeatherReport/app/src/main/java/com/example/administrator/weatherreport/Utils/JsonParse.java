package com.example.administrator.weatherreport.Utils;

import com.example.administrator.weatherreport.Model.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/8.
 */

public class JsonParse {
    public static Response readWeather(String response){
        //Map<String,Object> dataMap=new HashMap<String,Object>();
        Response response1=new Response();
        ObjectMapper objectMapper=new ObjectMapper();
        response=response.replace("fl","fengli").replace("fx","fengxiang");
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            response1=objectMapper.readValue(response,Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*JsonNode jsonNode=null;
        try {
            jsonNode=objectMapper.readTree(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(jsonNode!=null){

        }
*/
        return response1;
    }
}
