package com.example.simp_2;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(
        entities = {Usuario.class,Classroom.class,Student.class,Faltas.class},
        version = 1,
        exportSchema = false
)
@TypeConverters({DateConverter.class})
public abstract class AppData extends RoomDatabase {
    public abstract daoUsuario DAOusuario();
    public abstract daoClassroom DAOClassroom();
    public abstract  daoStudent DAOStudent();
    public abstract daoFaltas DAOFaltas();
}
