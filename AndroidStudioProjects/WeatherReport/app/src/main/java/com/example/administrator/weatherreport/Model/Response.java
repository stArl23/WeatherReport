package com.example.administrator.weatherreport.Model;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Response {
    private WeatherInformation data;
    private String status;

    public WeatherInformation getData() {
        return data;
    }

    public void setData(WeatherInformation data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Response[" +
                "data=" + data +
                ", status=" + status +
                ']';
    }
}
