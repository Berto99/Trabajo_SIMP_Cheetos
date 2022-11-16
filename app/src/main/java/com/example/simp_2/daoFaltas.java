package com.example.simp_2;

import androidx.room.Dao;
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

}
