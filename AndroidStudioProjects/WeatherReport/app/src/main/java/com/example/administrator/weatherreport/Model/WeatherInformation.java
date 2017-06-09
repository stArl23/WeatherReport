package com.example.administrator.weatherreport.Model;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/8.
 */

public class WeatherInformation {
    private Weather yesterday;
    private Weather[] forecast;
    private String ganmao;
    private String wendu;

    public WeatherInformation(Weather yesterday, Weather[] forecast, String ganmao, String wendu) {
        this.yesterday = yesterday;
        this.forecast = forecast;
        this.ganmao = ganmao;
        this.wendu = wendu;
    }

    public WeatherInformation() {
    }

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

    @Override
    public String toString() {
        return "WeatherInformation{" +
                "yesterday=" + yesterday +
                ", forecast=" + Arrays.toString(forecast) +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                '}';
    }
}

