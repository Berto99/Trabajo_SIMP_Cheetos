package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        foreignKeys = @ForeignKey(entity = Student.class,parentColumns =
        "id",childColumns = "fk_id_alumno")

        )

public class Faltas {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private int fk_id_alumno;
    private String fk_usuario;
    private Date fecha;


}
