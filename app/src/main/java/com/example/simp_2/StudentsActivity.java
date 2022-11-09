package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.simp_2.databinding.ActivityStudentsBinding;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStudentsBinding binding = ActivityStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Variables
        Button boton =findViewById(R.id.new_student);
        TextView nombre_usuario=findViewById(R.id.username_students_view);
        List<Student> lista_estudiantes;
        String nombre = null;
        String apellido= null;
        String usuario = null;
        int id = 0;

        //Acceder BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        Bundle extras =getIntent().getExtras();

            nombre = extras.getString("dato_nombre");
            apellido = extras.getString("dato_apellido");
            usuario = extras.getString("dato_usuario");
            id = extras.getInt("id_clase");
            nombre_usuario.setText(nombre + " " + apellido);


        binding.principalStudentsRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Student> studentsList = new ArrayList<>();

        /*Student estudiante = new Student(1,"Sauliguera",id);
        appDatabase.DAOStudent().insertarStudiante(estudiante);

        studentsList.add(estudiante);*/

        StudentAdapter adapter = new StudentAdapter();
        binding.principalStudentsRecycler.setAdapter(adapter);
        adapter.submitList(studentsList);

        if (studentsList.isEmpty()) {
            binding.emptyStudentsView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyStudentsView.setVisibility(View.GONE);
        }


        boton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddStudentActivity.class);
            startActivity(intent);
        });



    }
}
