package com.example.simp_2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;


@Dao
public interface daoClassroom {
    @Query("SELECT * FROM Classroom")
    List<Classroom> obtenerClase();

    @Insert
    void insertarClase(Classroom...classrooms);

    @Query("SELECT id FROM Classroom where name=:name")
    int  obtenerClaseid(String name);

    @Query("SELECT name FROM Classroom where id=:id")
    String obtenerClaseNombre(int id);

    @Query("SELECT grade FROM Classroom where id=:id")
    int obtenerClaseGrade(int id);
}
