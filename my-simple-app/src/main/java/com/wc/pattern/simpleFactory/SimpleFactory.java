package com.wc.pattern.simpleFactory;

public class SimpleFactory {
    public static Shape createShape(String type) {
        if ("circle".equals(type)) {
            return new Circle();
        } else if ("square".equals(type)) {
            return new Square();
        } else {
            throw new UnsupportedOperationException("不支持的类型");
        }
    }
}
