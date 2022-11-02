package com.example.simp_2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface daoUsuario {

    @Query("SELECT * FROM Usuario")
    List<Usuario> obtenerUsuarios();

    @Insert
    void insertarUsuario(Usuario...usuarios);

    @Query("SELECT * FROM Usuario where usuario = :usuario")
    List<Usuario>  obtenerUsuarioEspecifico(String usuario);


}
