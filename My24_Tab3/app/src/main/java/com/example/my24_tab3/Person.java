package com.example.my24_tab3;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    int age;

    //생성자 만드는 법 : 오마 -> Generate -> construct
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Getter Setter 만드는 법 : 오마 -> Generate -> Getter and Setter
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
}
