package com.wc.lamda;

public class Man {
    public String firstName;
    public String lastName;
    public int age;

    private Gender gender = Gender.MAN;

    public Man(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String toString() {
        return firstName + "," + lastName + "," + age;
    }
}
