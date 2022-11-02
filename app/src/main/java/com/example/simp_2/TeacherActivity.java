package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.simp_2.databinding.ActivityTeacherBinding;

import java.util.ArrayList;
import java.util.List;

public class TeacherActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTeacherBinding binding = ActivityTeacherBinding.inflate(getLayoutInflater());
        //Cogemos el layout de activity teacher.xml
        setContentView(binding.getRoot());

        //BBDD
        TextView nombre_usuario= findViewById(R.id.username_view);
        RecyclerView contenedor_clases = findViewById(R.id.principal_recycler);



        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();
        recibirDato(nombre_usuario);


        Bundle extras =getIntent().getExtras();
        String usuario = extras.getString("dato_usuario");
        appDatabase.DAOprofesor().insertarProfesor(new Profesor(usuario,"2DAMB"));

        //PARA MOSTRAR EL CONTENIDO DEL RECYCLER VIEW
        binding.principalRecycler.setLayoutManager(new LinearLayoutManager(this));



        //Cogemos el valor de la tabla clases
        appDatabase.DAOClassroom().insertarAlumno(new Classroom(1,"DAMA"));
        List <Classroom> clase = appDatabase.DAOClassroom().obtenerClase();



        ArrayList<Classroom> classroomList = new ArrayList<>();
        //Lo insertamos
        classroomList.add(clase.get(0));
        classroomList.add(new Classroom(1, "DAM-B"));
        classroomList.add(new Classroom(2, "DAW-A"));

        ClassroomAdapter adapter = new ClassroomAdapter();
        adapter.setOnItemClickListener(classroom -> {
            Intent intent = new Intent(this, StudentsActivity.class);
            startActivity(intent);
        });
        binding.principalRecycler.setAdapter(adapter);
        adapter.submitList(classroomList);

        if (classroomList.isEmpty()) {
            binding.emptyView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyView.setVisibility(View.GONE);
        }


    }

    private void recibirDato(TextView nombre_usuario){
        //Creamos elemento para recibir el dato de la clase main
        Bundle extras =getIntent().getExtras();
        String nombre=extras.getString("dato_nombre");
        String apellido = extras.getString("dato_apellido");
        nombre_usuario.setText(nombre+" "+apellido);
    }
}
