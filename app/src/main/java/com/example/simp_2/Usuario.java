package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey
    @NonNull
    String usuario;
    String contrasena;
    String nombre;
    String apellido;

    public Usuario (@NonNull String usuario, String contrasena, String nombre, String apellido){
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.nombre=nombre;
        this.apellido=apellido;
    }


}
