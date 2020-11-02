package com.wc.pattern.headfirst.decorator;

/**
 * @author shovel
 * @date 2018/11/2 15:46
 * @since 1.0.0
 */
public class TypeACoffee extends AbstractCoffee {
    private String name;

    public TypeACoffee(String name) {
        this.name = name;
    }

    @Override
    public String description() {
        return " type A coffee ";
    }

    @Override
    public int cost() {
        int cost = 0;
        if (SIZE_VENTI.equals(size)) {
            cost = 28;
        } else if (SIZE_GRANDE.equals(size)) {
            cost = 25;
        } else if (SIZE_TALL.equals(size)) {
            cost = 22;
        }
        return cost;
    }
}
