package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

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
        TextView numFaltas=findViewById(R.id.total_foults_text);
        Button mostrar=findViewById(R.id.show_button);

        //Acceso a BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        //Parametros que pasamos del anterior activity
        Bundle extras = getIntent().getExtras();
        alumno = extras.getString("dato_alumno");
        id = extras.getInt("id_alumno");
        usuario = extras.getString("dato_usuario");
        nombre = extras.getString("dato_nombre");
        apellido = extras.getString("dato_apellido");
        id_clase=extras.getInt("id_clase");

        texto_alumno.setText(alumno);
        faltas(appDatabase, injustficada, justficada, retraso, boton, id, usuario,nombre,apellido,id_clase);

        mostrar.setOnClickListener(view -> {
            mostrarResultado(appDatabase,id,numFaltas);
        });

    }

    private void faltas(AppData appDatabase, RadioButton injustficada, RadioButton justficada,
                        RadioButton retraso, Button boton, int id, String usuario,String nombre,String apellido,
                        int id_clase) {
        //Cunado pulse el boton
        boton.setOnClickListener(view -> {
            //Poner fecha actual
            Date date;
            Calendar calendar = Calendar.getInstance();
            date = calendar.getTime();
            Intent intent = new Intent(this, StudentsActivity.class);
            //Depende de la opcion que indiquemos, insertara una falta injustificada, retraso o justificara
            if (injustficada.isChecked()) {
                Toast.makeText(this, "Falta injustificada introducida", Toast.LENGTH_SHORT).show();
                appDatabase.DAOFaltas().insertarFalta(new Faltas(id, usuario, date, "I"));
                comprobarFaltas(appDatabase,id,usuario,nombre,apellido,id_clase);
            }

            else if (justficada.isChecked()) {
                justificarFalta(appDatabase,id);
            }
            else if (retraso.isChecked()) {
                Toast.makeText(this, "Retraso introducido correctamente", Toast.LENGTH_SHORT).show();
                appDatabase.DAOFaltas().insertarFalta(new Faltas(id, usuario, date, "R"));
                comprobarFaltas(appDatabase,id,usuario,nombre,apellido,id_clase);
            }
            else{
                //Pasamos los datos al activity anterior para que no se quede vacio
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
        //Variables para el popup
        GifImageView gif ;
        ImageButton close;
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.gif);
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.getWindow().setWindowAnimations(R.style.DialogAnim);
        gif=dialog.findViewById(R.id.gifKratos);
        gif.setImageResource(R.drawable.kratos);

        //Sonido cuando salga el popup
        MediaPlayer mp = MediaPlayer.create(this, R.raw.wasted);


        //Num de faltas por tipo
        int num_faltasInjus= appDatabase.DAOFaltas().numFaltas(id);
        //Los retrasos cuentan medio punto
        int num_retrasos = (appDatabase.DAOFaltas().numRetrasos(id)/2);


        //Obtenemos el id del estudiante
        Student student= appDatabase.DAOStudent().obteneridStudent(id);
        Intent intent = new Intent(this, StudentsActivity.class);
        //Si el num de faltas llega a 3
        if(num_faltasInjus>=3){
            mp.start();
            dialog.show();
            close=dialog.findViewById(R.id.cerrarGif);
            close.setOnClickListener(view -> {
                dialog.cancel();
                List<Faltas> faltas = appDatabase.DAOFaltas().faltasAlumno(id);
                for(int i = 0 ; i<faltas.size();i++){
                    appDatabase.DAOFaltas().borrarFaltas(faltas.get(i));
                }
                appDatabase.DAOFaltas().borrarStudent(student);

                intent.putExtra("id_alumno", id);
                intent.putExtra("dato_usuario", usuario);
                intent.putExtra("dato_nombre", nombre);
                intent.putExtra("dato_apellido", apellido);
                intent.putExtra("id_clase", id_clase);
                startActivity(intent);
            });
        }
        //Si la suma del num de faltas + retrasoso llega a 3
        else if ((num_retrasos+num_faltasInjus)>=3) {
            mp.start();
            dialog.show();
            close=dialog.findViewById(R.id.cerrarGif);
            close.setOnClickListener(view -> {
                dialog.cancel();
                List<Faltas> faltas = appDatabase.DAOFaltas().faltasAlumno(id);
                for(int i = 0 ; i<faltas.size();i++){
                    appDatabase.DAOFaltas().borrarFaltas(faltas.get(i));
                }
                appDatabase.DAOFaltas().borrarStudent(student);

                intent.putExtra("id_alumno", id);
                intent.putExtra("dato_usuario", usuario);
                intent.putExtra("dato_nombre", nombre);
                intent.putExtra("dato_apellido", apellido);
                intent.putExtra("id_clase", id_clase);
                startActivity(intent);
            });
        }
    }

    private void mostrarResultado(AppData appDatabase,int id,TextView texto){
        //Mostrar faltas con una consulta a la BBDD
        int numFaltasInjus=appDatabase.DAOFaltas().numFaltas(id);
        int numRetrasos=appDatabase.DAOFaltas().numRetrasos(id);
        texto.setText("Faltas injustificadas: "+numFaltasInjus +"\n"
        + "Retrasos: "+numRetrasos);
    }

    private void justificarFalta(AppData appDatabase,int id){
        //Lista de faltas
        List <Faltas> faltas;
        //Faltas de un alumno en concreto
        faltas = appDatabase.DAOFaltas().faltasAlumno(id);
        //Num de faltas del alumno
        int numFaltas= appDatabase.DAOFaltas().numFaltas(id);
        //Si no hay faltas
        if (numFaltas==0){
            Toast.makeText(this, "No tiene faltas", Toast.LENGTH_SHORT).show();
        }
        else {
            appDatabase.DAOFaltas().borrarFaltas(faltas.get(0));
            Toast.makeText(this, "Falta Justificada", Toast.LENGTH_SHORT).show();

        }
    }










}