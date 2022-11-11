package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
        ImageButton back = findViewById(R.id.backButton_students);
        List<Student> lista_estudiantes;
        String nombre = null;
        String apellido= null;
        int id = 0;
        List<Student> students;

        //Acceder BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();
        students=appDatabase.DAOStudent().obtenerStudens();

        Bundle extras =getIntent().getExtras();

                nombre = extras.getString("dato_nombre");
                apellido = extras.getString("dato_apellido");
                id = extras.getInt("id_clase");
                nombre_usuario.setText(nombre + " " + apellido);



        binding.principalStudentsRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Student> studentsList = new ArrayList<>();


        for (int i =0;i<students.size();i++){
            if(students.get(i).getFk_clase()==id) {
                studentsList.add(new Student(students.get(i).getNumber_list() ,students.get(i).getName(),students.get(i).getFk_clase()));
            }
        }


        StudentAdapter adapter = new StudentAdapter();
        binding.principalStudentsRecycler.setAdapter(adapter);
        adapter.submitList(studentsList);

        if (studentsList.isEmpty()) {
            binding.emptyStudentsView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyStudentsView.setVisibility(View.GONE);
        }


        String finalApellido = apellido;
        String finalNombre = nombre;
        int finalId = id;
        boton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddStudentActivity.class);
            intent.putExtra("dato_clase", finalId);
            intent.putExtra("dato_nombre2", finalNombre);
            intent.putExtra("dato_apellido2", finalApellido);
            startActivity(intent);
        });

        //Acción de volver para atrás
        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, TeacherActivity.class);
            startActivity(intent);
        });


    }
}
