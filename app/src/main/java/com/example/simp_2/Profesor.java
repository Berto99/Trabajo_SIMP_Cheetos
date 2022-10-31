package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = @ForeignKey(entity = Usuario.class,parentColumns =
                "usuario",childColumns = "usu_profe")
)
public class Profesor {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    String clase;
    String usu_profe;

    public Profesor(@NonNull String usu,String clase){
        this.usu_profe=usu;
        this.clase=clase;
    }

    public Profesor(String clase){
        this.clase=clase;
    }





}
