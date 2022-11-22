package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simp_2.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Locale;

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
        Button btnRegistrar = findViewById(R.id.singUp_button_logIn);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.mps2);

        List<Usuario> listaUsuarios;
        //Acceder a la BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        listaUsuarios = appDatabase.DAOusuario().obtenerUsuarios();

        comprobarUsuario(btnEntrar,user,pass,listaUsuarios);
        btnRegistrar.setOnClickListener(view -> {
            mp.start();
            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);

        });

    }

    protected void comprobarUsuario(Button btnEntrar, EditText user,EditText pass, List<Usuario> listaUsuarios){
        TextView nombre_usuario= findViewById(R.id.username_view);
        btnEntrar.setOnClickListener(view -> {
            String usu = user.getText().toString();
            String passwd = pass.getText().toString();
            String nombre =null;
            String apellido =null;
            int comprobacionUsuario = 0;
            int comprobacionPasswd = 0;
            //Comprobamos si ese usuario existe con su debida contraseña
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (usu.equals(listaUsuarios.get(i).usuario)) {
                    comprobacionUsuario = 1;
                    nombre=listaUsuarios.get(i).nombre.toString();
                    apellido=listaUsuarios.get(i).apellido.toString();
                }
                if (passwd.equals(listaUsuarios.get(i).contrasena)) {
                    comprobacionPasswd = 1;
                }
            }
            //Para que no pueda dejar en blanco los campos
            if (usu.equals("") || passwd.equals("")) {
                Toast.makeText(this, "ERROR:Campos Vacios", Toast.LENGTH_SHORT).show();
            }
            //Si esta bien pasa al siguiente activity
            else if (comprobacionUsuario == 1 && comprobacionPasswd == 1) {
                Intent intent = new Intent(this, TeacherActivity.class);
                intent.putExtra("dato_usuario",usu);
                intent.putExtra("dato_nombre",nombre);
                intent.putExtra("dato_apellido",apellido);

                startActivity(intent);
            }
            else {
                Toast.makeText(this, "ERROR:Datos Incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }




}