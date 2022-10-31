package com.example.simp_2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.simp_2.databinding.ActivityTeacherBinding;

import java.util.List;

public class TeacherActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTeacherBinding binding = ActivityTeacherBinding.inflate(getLayoutInflater());
        //Cogemos el layout de activity teacher.xml
        setContentView(binding.getRoot());

        TextView nombre_usuario= findViewById(R.id.username_view);
        RecyclerView contenedor_clases = findViewById(R.id.principal_recycler);

        List<Usuario> listaUsuarios;

        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();
        recibirDato(nombre_usuario);
    }

    private void recibirDato(TextView nombre_usuario){
        //Creamos elemento para recibir el dato de la clase main
        Bundle extras =getIntent().getExtras();
        String nombre=extras.getString("dato_nombre");
        String apellido = extras.getString("dato_apellido");
        nombre_usuario.setText(nombre+" "+apellido);
    }
}
