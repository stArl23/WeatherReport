package com.example.administrator.weatherreport.NetUtils;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by Administrator on 2017/6/3.
 */
public class HttpUtils {
    public static void setHttpRequest(final String address,final HandleResponse handleResponse){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try{
                    URL url=new URL(address);
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.connect();
                    InputStream inputStream=connection.getInputStream();
                    InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    String line=null;
                    StringBuffer response=new StringBuffer();
                    while((line=bufferedReader.readLine())!=null)
                        response.append(line);
                    if(handleResponse!=null)handleResponse.onFinish(response.toString());
                }
                catch(Exception e){
                    if(handleResponse!=null)handleResponse.onError(e);
                }
                finally {
                    if(connection!=null)
                        connection.disconnect();
                }
            }
        }).start();
    }

    public static void  main(String[] args){
        final String address="http://www.sojson.com/open/api/weather/json.shtml?city=杭州";
        setHttpRequest(address, new HandleResponse() {
            @Override
            public void onFinish(String response) {
                System.out.println(response);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
