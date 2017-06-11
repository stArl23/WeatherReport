package com.example.administrator.weatherreport.Model;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/8.
 */

public class WeatherInformation {
    private Weather yesterday;
    private Weather[] forecast;
    private String city;
    private String ganmao;
    private String wendu;


    public Weather getYesterday() {
        return yesterday;
    }

    public void setYesterday(Weather yesterday) {
        this.yesterday = yesterday;
    }

    public Weather[] getForecast() {
        return forecast;
    }

    public void setForecast(Weather[] forecast) {
        this.forecast = forecast;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "WeatherInformation[" +
                "yesterday=" + yesterday +
                ", forecast=" + Arrays.toString(forecast) +
                ", city='" + city +
                ", ganmao='" + ganmao +
                ", wendu='" + wendu +
                ']';
    }
}

