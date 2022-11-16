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

    @Query("SELECT MAX(number_list) from Student where fk_clase =:fk_clase")
    int obtenernumLista(int fk_clase);





}
