package com.example.simp_2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {Usuario.class,Profesor.class,Classroom.class},
        version = 1,
        exportSchema = false
)
public abstract class AppData extends RoomDatabase {
    public abstract daoUsuario DAOusuario();
    public abstract daoProfesor DAOprofesor();
    public abstract daoClassroom DAOClassroom();
}
