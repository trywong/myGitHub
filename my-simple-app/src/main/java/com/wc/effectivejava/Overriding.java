package com.wc.effectivejava;

public class Overriding {
    public static void main(String[] args) {
        Plant[] plants = new Plant[] { 
                new Plant(), 
                new Flower(), 
                new SunFlower() };
        for (Plant p : plants) {
            System.out.println(p.name());
        }
    }
}

class Plant {
    String name() {
        return "plant";
    }
}

class Flower extends Plant {
    @Override
    String name() {
        return "Flower";
    }
}

class SunFlower extends Flower {
    @Override
    String name() {
        return "SunFlower";
    }
}
