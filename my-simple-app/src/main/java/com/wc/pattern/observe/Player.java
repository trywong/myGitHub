package com.wc.pattern.observe;

/**
 * @author shovel
 * @date 2018/10/17 14:34
 * @since 1.0.0
 */
public class Player extends Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void beAttacked(AbstractController allyController) {
        System.out.println("!!" + name + "遭受攻击");
        allyController.notifyObservers(name);
    }

    @Override
    public void help() {
        System.out.println(name + "表示支持");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
