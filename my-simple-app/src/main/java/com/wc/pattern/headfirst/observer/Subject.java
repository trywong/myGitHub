package com.wc.pattern.headfirst.observer;

/**
 * @author shovel
 * @date 2018/11/1 11:30
 * @since 1.0.0
 */
public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
