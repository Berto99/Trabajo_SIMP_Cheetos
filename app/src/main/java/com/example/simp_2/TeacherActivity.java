package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.simp_2.databinding.ActivityTeacherBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TeacherActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTeacherBinding binding = ActivityTeacherBinding.inflate(getLayoutInflater());
        //Cogemos el layout de activity teacher.xml
        setContentView(binding.getRoot());

        //Variables
        TextView nombre_usuario= findViewById(R.id.username_view);
        Button boton = findViewById(R.id.button_registrer);
        ImageButton back = findViewById(R.id.backButton_teacher);
        String nombre = null;
        String apellido= null;
        String usuario = null;
        AtomicInteger id = new AtomicInteger();

        //BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        //Recibir dato del nombre y ponerlo en el edit text
        Bundle extras =getIntent().getExtras();
        if (extras!=null) {
            nombre = extras.getString("dato_nombre");
            apellido = extras.getString("dato_apellido");
            usuario = extras.getString("dato_usuario");
            nombre_usuario.setText(nombre + " " + apellido);
        }

        //PARA MOSTRAR EL CONTENIDO DEL RECYCLER VIEW
        binding.principalRecycler.setLayoutManager(new LinearLayoutManager(this));


        //Cogemos el valor de la tabla clases
        List <Classroom> clase = appDatabase.DAOClassroom().obtenerClase();

        ArrayList<Classroom> classroomList = new ArrayList<>();
        //Comprobaciones
        for(int i =0; i<clase.size();i++){
            if(clase.get(i).getFk_usuario().equals(usuario)){
                classroomList.add(new Classroom(clase.get(i).getGrade(),clase.get(i).getName(), clase.get(i).getFk_usuario()));
            }
        }

        //pasar al activity de student
        ClassroomAdapter adapter = new ClassroomAdapter();
        String finalUsuario1 = usuario;
        String finalNombre1 = nombre;
        String finalApellido1 = apellido;
        adapter.setOnItemClickListener(classroom -> {
            Intent intent = new Intent(this, StudentsActivity.class);
            intent.putExtra("dato_usuario", finalUsuario1);
            intent.putExtra("dato_nombre", finalNombre1);
            intent.putExtra("dato_apellido", finalApellido1);
            id.set(appDatabase.DAOClassroom().obtenerClaseid(classroom.getName()));
            intent.putExtra("id_clase", id.get());
            startActivity(intent);
        });
        binding.principalRecycler.setAdapter(adapter);
        adapter.submitList(classroomList);
        //Si el recycler esta vacio, saldra un mensaje
        if (classroomList.isEmpty()) {
            binding.emptyView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyView.setVisibility(View.GONE);
        }

        //Variable final de usuario para el intent
        String finalUsuario = usuario;
        String finalNombre = nombre;
        String finalApellido = apellido;

        //Boton para pasar al activity de crear clases
        boton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddClassActivity.class);
            intent.putExtra("dato_usuario2", finalUsuario);
            intent.putExtra("dato_nombre2", finalNombre);
            intent.putExtra("dato_apellido2", finalApellido);

            startActivity(intent);
        });

        //BOTOÓN DEL VOLVER PARA ATRÁS
        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }

}
