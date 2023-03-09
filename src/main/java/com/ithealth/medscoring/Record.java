package com.ithealth.medscoring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Record {

    @Id
    @GeneratedValue

    Long id;
    int age;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }
}
