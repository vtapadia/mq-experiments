package com.vtapadia.experiments.mqCommon;

import java.io.Serializable;

/**
 * Serializable is required, as this object is passed as Serialized entity.
 */
public class DummyObject implements Serializable {
    private String name;
    private int age;

    public DummyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DummyObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
