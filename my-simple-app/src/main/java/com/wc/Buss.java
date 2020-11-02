package com.wc;
class Buss {

    private String name;
    private int count;
    private double value;

    public Buss(String name, int count, double value) {
        this.name = name;
        this.count = count;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Buss{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", value=" + value +
                '}';
    }
}