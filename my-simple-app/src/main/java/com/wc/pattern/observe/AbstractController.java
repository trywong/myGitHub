package com.wc.pattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * 联盟控制
 * @author shovel
 * @date 2018/10/17 14:37
 * @since 1.0.0
 */
public abstract class AbstractController {
    protected List<Observer> observers = new ArrayList<>();

    public void addPlay(Observer observer) {
        System.out.println("+" + observer.getName() + "加入战队");
        observers.add(observer);
    }

    public void quitPlay(Observer observer) {
        System.out.println("-" + observer.getName() + "退出战队");
        observers.remove(observer);
    }

    public abstract void notifyObservers(String name);
}
