package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nombre_usuario= findViewById(R.id.student_name);
        Button boton = findViewById(R.id.register_student);

        //Acceder BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        List<Student> student;

        student=appDatabase.DAOStudent().obtenerStudens();

        boton.setOnClickListener(view -> {

        });
    }
}