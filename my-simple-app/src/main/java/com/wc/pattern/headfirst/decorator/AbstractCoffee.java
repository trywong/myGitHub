package com.wc.pattern.headfirst.decorator;

/**
 * @author shovel
 * @date 2018/11/2 15:46
 * @since 1.0.0
 */
public abstract class AbstractCoffee {
    /**大杯*/
    public static final String SIZE_VENTI = "venti";
    /**中杯*/
    public static final String SIZE_GRANDE = "grande";
    /**小杯*/
    public static final String SIZE_TALL = "tall";

    protected String size;

    public String description() {
        return "abstract useless description!";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public abstract int cost();
}
