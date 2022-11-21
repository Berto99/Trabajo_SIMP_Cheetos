package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        //Variables
        TextView texto_alumno = findViewById(R.id.name_total);
        String alumno;
        int id;
        String usuario;
        RadioButton injustficada = findViewById(R.id.injustificada);
        RadioButton justficada = findViewById(R.id.justificar);
        RadioButton retraso = findViewById(R.id.retraso);
        Button boton = findViewById(R.id.mostrar);


        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        Bundle extras = getIntent().getExtras();
        alumno = extras.getString("dato_alumno");
        id = extras.getInt("id_alumno");
        usuario = extras.getString("usuario");
        texto_alumno.setText(alumno);

        faltas(appDatabase, injustficada, justficada, retraso, boton, id, usuario);

    }

    private void faltas(AppData appDatabase, RadioButton injustficada, RadioButton justficada, RadioButton retraso, Button boton, int id, String usuario) {
        boton.setOnClickListener(view -> {
            Date date;
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            if (injustficada.isChecked()) {
                Toast.makeText(this, "Falta injustificada introducida", Toast.LENGTH_SHORT).show();
                appDatabase.DAOFaltas().insertarFalta(new Faltas(id, usuario, date, "I"));

            }

            if (justficada.isChecked()) {
                Toast.makeText(this, "Justificada correctamente", Toast.LENGTH_SHORT).show();

            }


            if (retraso.isChecked()) {
                Toast.makeText(this, "Retraso introducido correctamente", Toast.LENGTH_SHORT).show();
                appDatabase.DAOFaltas().insertarFalta(new Faltas(id, usuario, date, "R"));
            }

        });

    }

}