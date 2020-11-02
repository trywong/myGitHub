package com.wc.pattern.headfirst.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shovel
 * @date 2018/11/1 11:31
 * @since 1.0.0
 */
public class WeatherData implements Subject {
    List<Observer> observers;

    private int temprature;
    private int rain;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setWeatherData(int temprature, int rain) {
        this.temprature = temprature;
        this.rain = rain;

        // 有最新数据更新，通知观察者
        this.notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.update(temprature, rain);
        }
    }
}
