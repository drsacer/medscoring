package com.ithealth.medscoring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Record {

    @Id
    @GeneratedValue
    Long id;

    // ako je greška prilikom pokretanja: Caused by: org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException:
    // NULL not allowed for column "AGE"; SQL statement:" upisati u h2 bazu :
    // ALTER TABLE RECORD ALTER COLUMN AGE SET NULL;  - nekad ne radi :-)
    //@Column(nullable = false)
    String age;
    String gender;
    String bmi;
    String smoker;
    String dailycigarettessmoker;
    String smokingduration;

    String weeklycigarettes;

    String dailycigarettesquit;
    String stoppedsmoking;


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String  getAge () {
        return age;
    }

    public void setAge (String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public String getBmi() {
        return bmi;
    }
    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public String getDailycigarettessmoker() {
        return dailycigarettessmoker;
    }

    public void setDailycigarettessmoker(String dailycigarettessmoker) {
        this.dailycigarettessmoker = dailycigarettessmoker;
    }

    public String getSmokingduration() {
        return smokingduration;
    }

    public void setSmokingduration(String smokingduration) {
        this.smokingduration = smokingduration;
    }

    public String getWeeklycigarettes() {
        return weeklycigarettes;
    }

    public void setWeeklycigarettes(String weeklycigarettes) {
        this.weeklycigarettes = weeklycigarettes;
    }

    public String getDailycigarettesquit() {
        return dailycigarettesquit;
    }

    public void setDailycigarettesquit(String dailycigarettesquit) {
        this.dailycigarettesquit = dailycigarettesquit;
    }

    public String getStoppedsmoking() {
        return stoppedsmoking;
    }

    public void setStoppedsmoking(String stoppedsmoking) {
        this.stoppedsmoking = stoppedsmoking;
    }
}

