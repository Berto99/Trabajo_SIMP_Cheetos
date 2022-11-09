package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        //Variables
        TextView nombre_usuario= findViewById(R.id.username_view);
        Button boton = findViewById(R.id.button_registrer);
        int id;

        //BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        //Recibir dato del nombre y ponerlo en el edit text

        Bundle extras =getIntent().getExtras();
        String nombre=extras.getString("dato_nombre");
        String apellido = extras.getString("dato_apellido");
        String usuario15= extras.getString("dato_usuario");
        nombre_usuario.setText(nombre+" "+apellido);


        id = appDatabase.DAOClassroom().obteneridClase();

        //PARA MOSTRAR EL CONTENIDO DEL RECYCLER VIEW
        binding.principalRecycler.setLayoutManager(new LinearLayoutManager(this));


        //Cogemos el valor de la tabla clases

        List <Classroom> clase = appDatabase.DAOClassroom().obtenerClase();


        ArrayList<Classroom> classroomList = new ArrayList<>();
        //Comprobaciones
        for(int i =0; i<clase.size();i++){
            if(clase.get(i).getFk_usuario().equals(usuario15)){
                classroomList.add(new Classroom(clase.get(i).getGrade(),clase.get(i).getName(), clase.get(i).getFk_usuario()));
            }
        }

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

        boton.setOnClickListener( view -> {
            Intent intent = new Intent(this, AddClassActivity.class);
            intent.putExtra("dato_usuario2",usuario15);
            startActivity(intent);
        });

    }

}
