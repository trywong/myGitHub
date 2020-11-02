package com.wc.pattern.build;

public class Actor {
    private int type;
    private String name;
    private int sex;
    private String face;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "Actor [type=" + type + ", name=" + name + ", sex=" + sex + ", face=" + face + "]";
    }
}
