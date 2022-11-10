package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
        (foreignKeys = @ForeignKey(entity = Classroom.class,parentColumns =
                "id",childColumns = "fk_clase")
        )

public class Student {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private int fk_clase;
    private int number_list;
    private String name;


    public Student(int number_list, String name, int fk) {
        this.name = name;
        this.number_list = number_list;
        this.fk_clase=fk;
    }

    public Student() {
    }

    public int getNumber_list() {
        return number_list;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getFk_clase() {
        return fk_clase;
    }

    public void setFk_clase(int fk_clase) {
        this.fk_clase = fk_clase;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setNumber_list(int number_list) {
        this.number_list = number_list;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name == student.name && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number_list, name);
    }
}
