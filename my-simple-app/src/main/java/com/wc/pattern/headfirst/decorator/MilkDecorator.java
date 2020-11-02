package com.wc.pattern.headfirst.decorator;

/**
 * @author shovel
 * @date 2018/11/2 15:56
 * @since 1.0.0
 */
public class MilkDecorator extends AbstractDecorator {
    private AbstractCoffee coffee;

    public MilkDecorator(AbstractCoffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String description() {
        return coffee.description() + " 加牛奶 ";
    }

    @Override
    public int cost() {
        int cost = 0;
        if (SIZE_VENTI.equals(coffee.getSize())) {
            cost = 8;
        } else if (SIZE_GRANDE.equals(coffee.getSize())) {
            cost = 5;
        } else if (SIZE_TALL.equals(coffee.getSize())) {
            cost = 2;
        }

        return cost + coffee.cost();
    }
}
