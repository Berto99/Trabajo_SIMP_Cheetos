package com.example.simp_2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.google.android.material.internal.ViewOverlayImpl;

import java.util.List;

@Dao
public interface daoFaltas {
    @Query("SELECT * FROM Faltas")
    List<Faltas> obtenerFaltas();

    @Insert
    void insertarFalta(Faltas...faltas);

    @Delete
    void borrarStudent(Student...students);

    @Query("SELECT COUNT(id) from Faltas where fk_id_alumno=:fk_id_alumno and tipo='I'")
    int numFaltas(int fk_id_alumno);

    @Query("SELECT COUNT(id) from Faltas where fk_id_alumno=:fk_id_alumno and tipo='R'")
    int numRetrasos(int fk_id_alumno);

    @Delete
    void  borrarFaltas(Faltas...faltas);

    @Query("SELECT * from Faltas where fk_id_alumno=:fk_id_alumno")
    List<Faltas> faltasAlumno(int fk_id_alumno);


}
