package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simp_2.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Variables
        EditText user = findViewById(R.id.username_edit);
        EditText pass = findViewById(R.id.password_edit);
        Button btnEntrar = findViewById(R.id.next_button);
        Button btnRegistrar = findViewById(R.id.registar);

        List<Usuario> listaUsuarios;

        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        //appDatabase.DAOusuario().insertarUsuario(new Usuario("Berto18","1234","Alberto","Ruiz"));

        listaUsuarios = appDatabase.DAOusuario().obtenerUsuarios();

        comprobarUsuario(btnEntrar,user,pass,listaUsuarios);

        btnRegistrar.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);
        });




    }

    private void comprobarUsuario(Button btnEntrar, EditText user,EditText pass, List<Usuario> listaUsuarios){
        TextView nombre_usuario= findViewById(R.id.username_view);
        btnEntrar.setOnClickListener(view -> {
            String usu = user.getText().toString();
            String passwd = pass.getText().toString();
            int comprobacionUsuario = 0;
            int comprobacionPasswd = 0;

            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (usu.equals(listaUsuarios.get(i).usuario)) {
                    comprobacionUsuario = 1;
                }
                if (passwd.equals(listaUsuarios.get(i).contrasena)) {
                    comprobacionPasswd = 1;
                }
            }
            if (usu.equals("") || passwd.equals("")) {
                Toast.makeText(this, "ERROR:Campos Vacios", Toast.LENGTH_SHORT).show();
            }
            else if (comprobacionUsuario == 1 && comprobacionPasswd == 1) {
                Intent intent = new Intent(this, TeacherActivity.class);
                startActivity(intent);


            }
            else {
                Toast.makeText(this, "ERROR:Datos Incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }




}