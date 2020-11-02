package com.wc.thingking_in_java;

public enum RMBUnit {
    POINT(0.1f, "壹角"),
    HALF(0.5f, "伍角"),
    ONE(1, "壹圆"),
    FIVE(5, "伍圆"),
    TEN(10, "拾圆"),
    TWENTY(20, "贰拾圆"),
    FIFTY(50, "伍拾圆"),
    HUNDRED(100, "壹佰圆");
    
    private float value;
    private String cn;
    private RMBUnit(float value, String cn) {
        this.value = value;
        this.cn = cn;
        System.out.println("-");
    }
    
    RMBUnit(){}
    
    @Override
    public String toString() {
        return value + ":" + cn;
    }
}
