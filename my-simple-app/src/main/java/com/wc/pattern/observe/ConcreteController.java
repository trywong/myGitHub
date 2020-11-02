package com.wc.pattern.observe;

/**
 * @author shovel
 * @date 2018/10/17 14:51
 * @since 1.0.0
 */
public class ConcreteController extends AbstractController {
    @Override
    public void notifyObservers(String name) {
        for (Observer observer : observers) {
            if (!observer.getName().equals(name)) {
                observer.help();
            }
        }
    }
}
