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

}
