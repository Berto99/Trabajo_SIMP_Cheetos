package com.example.simp_2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface daoProfesor {
    @Query("SELECT * FROM Profesor where usu_profe = :profesor")
    List<Profesor> obtenerClases(String profesor);

    @Insert
    void insertarProfesor(Profesor...profesors);


}
