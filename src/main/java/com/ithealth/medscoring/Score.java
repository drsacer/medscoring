package com.ithealth.medscoring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Score {

    @Id
    @GeneratedValue
    Long id;

    String pitanje;

    String record_ime_stupca;

    int bod1;
    int bod2;
    int bod3;
    int bod4;
    int bod5;
    String odgovor1;
    String odgovor2;
    String odgovor3;
    String odgovor4;
    String odgovor5;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return pitanje;
    }

    public void setQuestion(String question) {
        this.pitanje = question;
    }

    public int getBod1() {
        return bod1;
    }

    public void setBod1(int bod1) {
        this.bod1 = bod1;
    }

    public int getBod2() {
        return bod2;
    }

    public void setBod2(int bod2) {
        this.bod2 = bod2;
    }

    public int getBod3() {
        return bod3;
    }

    public void setBod3(int bod3) {
        this.bod3 = bod3;
    }

    public int getBod4() {
        return bod4;
    }

    public void setBod4(int bod4) {
        this.bod4 = bod4;
    }

    public int getBod5() {
        return bod5;
    }

    public void setBod5(int bod5) {
        this.bod5 = bod5;
    }

    public String getOdgovor1() {
        return odgovor1;
    }

    public void setOdgovor1(String odgovor1) {
        this.odgovor1 = odgovor1;
    }

    public String getOdgovor2() {
        return odgovor2;
    }

    public void setOdgovor2(String odgovor2) {
        this.odgovor2 = odgovor2;
    }

    public String getOdgovor3() {
        return odgovor3;
    }

    public void setOdgovor3(String odgovor3) {
        this.odgovor3 = odgovor3;
    }

    public String getOdgovor4() {
        return odgovor4;
    }

    public void setOdgovor4(String odgovor4) {
        this.odgovor4 = odgovor4;
    }

    public String getOdgovor5() {
        return odgovor5;
    }

    public void setOdgovor5(String odgovor5) {
        this.odgovor5 = odgovor5;
    }
    public String getColumnNameInRecord() {
        return record_ime_stupca;
    }

    public void setColumnNameInRecord(String columnNameInRecord) {
        this.record_ime_stupca = columnNameInRecord;
    }


    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public String getRecord_ime_stupca() {
        return record_ime_stupca;
    }

    public void setRecord_ime_stupca(String record_ime_stupca) {
        this.record_ime_stupca = record_ime_stupca;
    }



    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", question='" + pitanje + '\'' +
                ", point1=" + bod1 +
                ", point2=" + bod2 +
                ", point3=" + bod3 +
                ", point4=" + bod4 +
                ", point5=" + bod5 +
                ", answer1='" + odgovor1 + '\'' +
                ", answer2='" + odgovor2 + '\'' +
                ", answer3='" + odgovor3 + '\'' +
                ", answer4='" + odgovor4 + '\'' +
                ", answer5='" + odgovor5 + '\'' +
                '}';
    }
}
