package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        //Variables
        EditText nombre_usuario= findViewById(R.id.student_name);
        Button boton = findViewById(R.id.register_student);
        String nombre = null;
        String apellido = null;
        int id = 0;
        String usuario;

        //Acceder BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        //Datos del Student Activity
        Bundle extras =getIntent().getExtras();
        nombre=extras.getString("dato_nombre");
        apellido=extras.getString("dato_apellido");
        id=extras.getInt("id_clase");
        usuario= extras.getString("dato_usuario");

        //Variables Auxiliares para el intent
        AtomicReference<String> nombreAux= new AtomicReference<>(nombre);
        AtomicReference<String> apellidoAux= new AtomicReference<>(apellido);
        AtomicInteger idAux= new AtomicInteger(id);


        List<Student> student;

        student=appDatabase.DAOStudent().obtenerStudens();

        String finalNombre = nombre;
        String finalApellido = apellido;
        int finalId = id;
        boton.setOnClickListener(view -> {
            String nombre_student= String.valueOf(nombre_usuario.getText());
            int i,comprobacion = 0;
            int num_lista=appDatabase.DAOStudent().obtenernumLista(idAux.get());
            //Comprobacion de una lista sacada de la BBDD si el usuario existe
            for( i =0;i<student.size();i++){
                if (student.get(i).getName().equalsIgnoreCase(nombre_student)){
                    comprobacion=1;
                }
            }
            if(comprobacion==1){
                Toast.makeText(this, "Este alumno ya existe ", Toast.LENGTH_SHORT).show();
            }
            else {
                Student estudiante = new Student(num_lista, nombre_student, idAux.get());
                appDatabase.DAOStudent().insertarStudiante(estudiante);
                Intent intent = new Intent(this, StudentsActivity.class);
                intent.putExtra("dato_nombre", finalNombre);
                intent.putExtra("dato_apellido", finalApellido);
                intent.putExtra("id_clase", finalId);
                intent.putExtra("dato_usuario",usuario);
                startActivity(intent);
            }

        });
    }
}