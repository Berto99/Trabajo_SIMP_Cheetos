package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;


public class RegistroActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText usuario = findViewById(R.id.username_edit_singUp);
        EditText passwd = findViewById(R.id.password_edit_singUp);
        EditText nombre = findViewById(R.id.name_edit);
        EditText apellido = findViewById(R.id.surname_edit);
        Button boton = findViewById(R.id.singUp_boton);

        List<Usuario> listaUsuarios;

        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        listaUsuarios = appDatabase.DAOusuario().obtenerUsuarios();

        boton.setOnClickListener(view -> {
            String usu, pass, nom, apell;
            int comprobacion = 0;
            usu = usuario.getText().toString();
            pass = passwd.getText().toString();
            nom = nombre.getText().toString();
            apell = apellido.getText().toString();

            if (usu.equals("") || pass.equals("") || nom.equals("") || apell.equals("")) {
                comprobacion = 0;
                Toast.makeText(this, "ERROR:Campos vacios", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < listaUsuarios.size(); i++) {
                    if (listaUsuarios.get(i).usuario.equals(usu)) {
                        comprobacion = 1;
                    }
                }
                if (comprobacion == 1) {
                    Toast.makeText(this, "Ya existe ese usuario", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();
                    appDatabase.DAOusuario().insertarUsuario(new Usuario(usu, pass, nom, apell));
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
