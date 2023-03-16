package com.ithealth.medscoring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Record {

    @Id
    @GeneratedValue

    Long id;

    String gender;
    String age;
    String smoking;
    String dailycigarettessmoker;
    String smokingduration;
    String weeklycigarettes;
    String stoppedsmoking;
    String dailycigarettesquit;
    String bmi;
    String alcohol;
    String activity;
    String CV;
    String diabetes;
    String heart;
    String bloodpressure;
    String stroke;
    String cholesterol;
    String LDL;
    String systolic;
    String diastolic;
    String heartbeat;
    String chronic;
    String medication;
    String migraine;
    String hormonaltherapy;
    String eclampsia;
    String pregnant;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public String getAge () {
        return age;
    }

    public void setAge (String age) {
        this.age = age;
    }

    public String getSmoking () {
        return smoking;
    }

    public void setSmoking (String smoking) {
        this.smoking = smoking;
    }

    public String getDailycigarettessmoker () {
        return dailycigarettessmoker;
    }

    public void setDailycigarettessmoker (String dailycigarettessmoker) {
        this.dailycigarettessmoker = dailycigarettessmoker;
    }

    public String getSmokingduration () {
        return smokingduration;
    }

    public void setSmokingduration (String smokingduration) {
        this.smokingduration = smokingduration;
    }

    public String getWeeklycigarettes () {
        return weeklycigarettes;
    }

    public void setWeeklycigarettes (String weeklycigarettes) {
        this.weeklycigarettes = weeklycigarettes;
    }

    public String getStoppedsmoking () {
        return stoppedsmoking;
    }

    public void setStoppedsmoking (String stoppedsmoking) {
        this.stoppedsmoking = stoppedsmoking;
    }

    public String getDailycigarettesquit () {
        return dailycigarettesquit;
    }

    public void setDailycigarettesquit (String dailycigarettesquit) {
        this.dailycigarettesquit = dailycigarettesquit;
    }

    public String getBmi () {
        return bmi;
    }

    public void setBmi (String bmi) {
        this.bmi = bmi;
    }

    public String getAlcohol () {
        return alcohol;
    }

    public void setAlcohol (String alcohol) {
        this.alcohol = alcohol;
    }

    public String getActivity () {
        return activity;
    }

    public void setActivity (String activity) {
        this.activity = activity;
    }

    public String getCV () {
        return CV;
    }

    public void setCV (String CV) {
        this.CV = CV;
    }

    public String getDiabetes () {
        return diabetes;
    }

    public void setDiabetes (String diabetes) {
        this.diabetes = diabetes;
    }

    public String getHeart () {
        return heart;
    }

    public void setHeart (String heart) {
        this.heart = heart;
    }

    public String getBloodpressure () {
        return bloodpressure;
    }

    public void setBloodpressure (String bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public String getStroke () {
        return stroke;
    }

    public void setStroke (String stroke) {
        this.stroke = stroke;
    }

    public String getCholesterol () {
        return cholesterol;
    }

    public void setCholesterol (String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getLDL () {
        return LDL;
    }

    public void setLDL (String LDL) {
        this.LDL = LDL;
    }

    public String getSystolic () {
        return systolic;
    }

    public void setSystolic (String systolic) {
        this.systolic = systolic;
    }

    public String getDiastolic () {
        return diastolic;
    }

    public void setDiastolic (String diastolic) {
        this.diastolic = diastolic;
    }

    public String getHeartbeat () {
        return heartbeat;
    }

    public void setHeartbeat (String heartbeat) {
        this.heartbeat = heartbeat;
    }

    public String getChronic () {
        return chronic;
    }

    public void setChronic (String chronic) {
        this.chronic = chronic;
    }

    public String getMedication () {
        return medication;
    }

    public void setMedication (String medication) {
        this.medication = medication;
    }

    public String getMigraine () {
        return migraine;
    }

    public void setMigraine (String migraine) {
        this.migraine = migraine;
    }

    public String getHormonaltherapy () {
        return hormonaltherapy;
    }

    public void setHormonaltherapy (String hormonaltherapy) {
        this.hormonaltherapy = hormonaltherapy;
    }

    public String getEclampsia () {
        return eclampsia;
    }

    public void setEclampsia (String eclampsia) {
        this.eclampsia = eclampsia;
    }

    public String getPregnant () {
        return pregnant;
    }

    public void setPregnant (String pregnant) {
        this.pregnant = pregnant;
    }
}
