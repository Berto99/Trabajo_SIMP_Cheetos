package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        String nombre = null;
        String apellido= null;
        int id = 0;
        List<Student> students;
        String usuario;
        TextView chosen_class= findViewById(R.id.chosen_class);

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

        //Poner clase y el curso en el textView
        chosen_class.setText(appDatabase.DAOClassroom().obtenerClaseGrade(id)
            + "º "+ appDatabase.DAOClassroom().obtenerClaseNombre(id));

        //MOSTRAR EL RECYCLERVIEW
        binding.principalStudentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Student> studentsList = new ArrayList<>();
        for (int i =0;i<students.size();i++){
            if(students.get(i).getFk_clase()==id) {
                studentsList.add(new Student(students.get(i).getNumber_list() ,students.get(i).getName(),students.get(i).getFk_clase()));
            }
        }
        //Adaptador del recyclerview
        StudentAdapter adapter = new StudentAdapter();
        binding.principalStudentsRecycler.setAdapter(adapter);
        adapter.submitList(studentsList);
        String finalNombre1 = nombre;
        String finalApellido1 = apellido;
        int finalId1 = id;
        //Cuando pulses en alguno de los elementos del recyclerView
        adapter.setOnItemClickListener(student -> {
            Intent intent = new Intent(this, TotalActivity.class);
            intent.putExtra("dato_alumno", student.getName());
            int id_alumno =appDatabase.DAOStudent().obteneridStudentporNombre(student.getName());
            intent.putExtra("id_alumno",id_alumno);
            intent.putExtra("dato_usuario",usuario);
            intent.putExtra("dato_nombre", finalNombre1);
            intent.putExtra("dato_apellido", finalApellido1);
            intent.putExtra("id_clase", finalId1);
            startActivity(intent);
        });
        //Si el recycler esta vacio, enseña un mensaje por defecto
        if (studentsList.isEmpty()) {
            binding.emptyStudentsView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyStudentsView.setVisibility(View.GONE);
        }

        String finalApellido = apellido;
        String finalNombre = nombre;
        int finalId = id;
        //Boton de añadir estudinate
        boton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddStudentActivity.class);
            intent.putExtra("dato_nombre", finalNombre);
            intent.putExtra("dato_apellido",finalApellido);
            intent.putExtra("dato_usuario",usuario);
            intent.putExtra("id_clase",finalId);
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
