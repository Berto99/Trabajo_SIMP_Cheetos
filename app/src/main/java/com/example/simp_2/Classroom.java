package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Objects;

import kotlin.contracts.Returns;

@Entity(
        foreignKeys = @ForeignKey(entity = Usuario.class,parentColumns =
                "usuario",childColumns = "fk_usuario")
)
public class Classroom {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    private String fk_usuario;
    private int grade;
    private String name;

    public Classroom(int grade, String name,String fk) {
        this.grade = grade;
        this.name = name;
        this.fk_usuario=fk;
    }

    public Classroom() {

    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String getFk_usuario(){
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return grade == classroom.grade && name.equals(classroom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, name);
    }
}
