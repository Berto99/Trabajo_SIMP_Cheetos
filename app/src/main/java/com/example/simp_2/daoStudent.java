package com.example.simp_2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface daoStudent {
    @Query("SELECT * FROM student")
    List<Student> obtenerStudens();

    @Insert
    void insertarStudiante(Student...students);

}
