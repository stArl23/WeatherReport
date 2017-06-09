package com.example.administrator.weatherreport.NetUtils;

/**
 * Created by Administrator on 2017/6/3.
 */
public interface HandleResponse {
    void onFinish(String response);
    void onError(Exception e);
}
