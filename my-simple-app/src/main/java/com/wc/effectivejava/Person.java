package com.wc.effectivejava;

public class Person {
    private final String idNumber;    // 身份证号
    private final String name;        // 姓名
    private final Integer gender;     // 性别
    private final float height;     // 身高
    private final float weight;     // 体重

    public static class Builder {
        private final String idNumber;    // 身份证号
        private final String name;        // 姓名

        private Integer gender = 0;     // 性别
        private float height = 0f;     // 身高
        private float weight = 0f;     // 体重

        public Builder(String idNumber, String name) {
            this.idNumber = idNumber;
            this.name = name;
        }

        public Builder gender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public Builder height(float height) {
            this.height = height;
            return this;
        }

        public Builder weight(float weight) {
            this.weight = weight;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        this.idNumber = builder.idNumber;
        this.name = builder.name;
        this.gender = builder.gender;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    @Override
    public String toString() {
        return "Builder [idNumber=" + idNumber + ", name=" + name + ", gender=" + gender + ", height=" + height + ", weight=" + weight + "]";
    }

    public static void main(String[] args) {
        Person person = new Person.Builder("500235********1234", "张三").gender(0).weight(60.5f).build();
        System.out.println(person.toString());
    }
}
