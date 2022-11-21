package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        //Variables
        TextView texto_alumno = findViewById(R.id.name_total);
        String alumno;
        int id,id_clase;
        String usuario,nombre,apellido;
        RadioButton injustficada = findViewById(R.id.injustificada);
        RadioButton justficada = findViewById(R.id.justificar);
        RadioButton retraso = findViewById(R.id.retraso);
        Button boton = findViewById(R.id.save_foults_button);


        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        Bundle extras = getIntent().getExtras();
        alumno = extras.getString("dato_alumno");
        id = extras.getInt("id_alumno");
        usuario = extras.getString("dato_usuario");
        nombre = extras.getString("dato_nombre");
        apellido = extras.getString("dato_apellido");
        id_clase=extras.getInt("id_clase");

        texto_alumno.setText(alumno);

        faltas(appDatabase, injustficada, justficada, retraso, boton, id, usuario,nombre,apellido,id_clase);

    }

    private void faltas(AppData appDatabase, RadioButton injustficada, RadioButton justficada,
                        RadioButton retraso, Button boton, int id, String usuario,String nombre,String apellido,
                        int id_clase) {
        boton.setOnClickListener(view -> {
            Date date;
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            Intent intent = new Intent(this, StudentsActivity.class);
            if (injustficada.isChecked()) {
                Toast.makeText(this, "Falta injustificada introducida", Toast.LENGTH_SHORT).show();
                appDatabase.DAOFaltas().insertarFalta(new Faltas(id, usuario, date, "I"));
                comprobarFaltas(appDatabase,id,usuario,nombre,apellido,id_clase);
            }

            else if (justficada.isChecked()) {
                Toast.makeText(this, "Justificada correctamente", Toast.LENGTH_SHORT).show();
            }

            else if (retraso.isChecked()) {
                Toast.makeText(this, "Retraso introducido correctamente", Toast.LENGTH_SHORT).show();
                appDatabase.DAOFaltas().insertarFalta(new Faltas(id, usuario, date, "R"));
            }

            else{
                intent.putExtra("id_alumno", id);
                intent.putExtra("dato_usuario", usuario);
                intent.putExtra("dato_nombre", nombre);
                intent.putExtra("dato_apellido", apellido);
                intent.putExtra("id_clase", id_clase);
                startActivity(intent);
            }



        });

    }

    private void comprobarFaltas(AppData appDatabase,int id,String usuario,String nombre,String apellido,
                                 int id_clase){
        int num_faltas= appDatabase.DAOFaltas().numFaltas(id);
        Student student= appDatabase.DAOStudent().obteneridStudent(id);
        Intent intent = new Intent(this, StudentsActivity.class);
        if(num_faltas>=3){
            List<Faltas> faltas = appDatabase.DAOFaltas().faltasAlumno(id);
            for(int i = 0 ; i<faltas.size();i++){
                appDatabase.DAOFaltas().borrarFaltas(faltas.get(i));
            }
            appDatabase.DAOFaltas().borrarStudent(student);
            Toast.makeText(this, "Has llegado a 3 faltas, quedas Eliminado", Toast.LENGTH_SHORT).show();
            intent.putExtra("id_alumno", id);
            intent.putExtra("dato_usuario", usuario);
            intent.putExtra("dato_nombre", nombre);
            intent.putExtra("dato_apellido", apellido);
            intent.putExtra("id_clase", id_clase);
            startActivity(intent);

        }

    }

}