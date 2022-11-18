package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.simp_2.databinding.ActivityStudentsBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
        Button boton_faltas = findViewById(R.id.new_student);
        List<Student> lista_estudiantes;
        String nombre = null;
        String apellido= null;
        int id = 0;
        List<Student> students;
        String usuario;
        CheckBox injus = findViewById(R.id.injus_checkBox);

        //Acceder BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();
        students=appDatabase.DAOStudent().obtenerStudens();

        //OBTENER EL NOMBRE DEL USUARIO Y PONERLO EN EL TEXT VIEW
        Bundle extras =getIntent().getExtras();
        nombre = extras.getString("dato_nombre");
        apellido = extras.getString("dato_apellido");
        id = extras.getInt("id_clase");
        usuario=extras.getString("dato_usuario");
        nombre_usuario.setText(nombre + " " + apellido);

        //MOSTRAR EL RECYCLERVIEW
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
        String alumno;
        int contador=0;
        adapter.setOnItemClickListener(student -> {
            Intent intent = new Intent(this, TotalActivity.class);
            intent.putExtra("dato_alumno", student.getName());
            boton_faltas.setOnClickListener(view -> {
                if(injus.isChecked()){
                    appDatabase.DAOFaltas().insertarFalta(new Faltas(student.getId(),usuario,));
                }
            });
            startActivity(intent);
        });

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
            startActivity(intent);

        });

        //BOTÓN DE VOLVER PARA ATRÁS
        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, TeacherActivity.class);
            intent.putExtra("dato_nombre", finalNombre);
            intent.putExtra("dato_apellido",finalApellido);
            intent.putExtra("dato_usuario",usuario);
            startActivity(intent);

        });
    }
}
