package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        foreignKeys = {@ForeignKey(entity = Student.class,parentColumns =
                "id",childColumns = "fk_id_alumno"),

                @ForeignKey(entity = Usuario.class,parentColumns =
                        "usuario",childColumns = "fk_usuario")}



)

public class Faltas {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private int fk_id_alumno;
    private String fk_usuario;
    private Date fecha;
    private String tipo;


    public Faltas(int fk_id_alumno, String fk_usuario, Date fecha,String tipo) {
        this.fk_id_alumno = fk_id_alumno;
        this.fk_usuario = fk_usuario;
        this.fecha = fecha;
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public int getFk_id_alumno() {
        return fk_id_alumno;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFk_id_alumno(int fk_id_alumno) {
        this.fk_id_alumno = fk_id_alumno;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
