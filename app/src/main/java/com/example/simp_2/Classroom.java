package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Classroom {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    private int grade;
    private String name;

    public Classroom(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
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
