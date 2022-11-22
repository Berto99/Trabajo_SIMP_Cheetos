package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class AddClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        EditText grado = findViewById(R.id.grade_class_input);
        EditText nombreClase= findViewById(R.id.name_class_input);
        Button boton = findViewById(R.id.save_button);

        //Acceder BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();
        List<Classroom> clase;


        clase= appDatabase.DAOClassroom().obtenerClase();

        //Recibimos el dato del usuario del activity de classroom
        Bundle extras =getIntent().getExtras();
        String usuario= extras.getString("dato_usuario2");
        String nombre = extras.getString("dato_nombre2");
        String apellido = extras.getString("dato_apellido2");

        boton.setOnClickListener(view -> {
            String grade,nombreClass;
            String aux, aux2;
            int comprobacion=0;
            grade = grado.getText().toString();
            nombreClass=nombreClase.getText().toString();
            //No puede dejar los campos vacios
            if (grade.equals("")||nombreClass.equals("")){
                Toast.makeText(this, "ERROR:Campos vacios", Toast.LENGTH_SHORT).show();
            }
            else{
                //recorre una lista de clases para comprobar si existe
                for (int i = 0; i < clase.size(); i++) {
                    aux=Integer.toString(clase.get(i).getGrade());
                    if (aux.equalsIgnoreCase(grade)&& clase.get(i).getName().equalsIgnoreCase(nombreClass)){
                        comprobacion=1;
                    }
                }
                if (comprobacion==1){
                    Toast.makeText(this, "ERROR:Ya existe esa clase", Toast.LENGTH_SHORT).show();
                }
                else{
                    appDatabase.DAOClassroom().insertarClase(new Classroom((Integer.parseInt(grade)),nombreClass,usuario));
                    Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, TeacherActivity.class);
                    intent.putExtra("dato_usuario",usuario);
                    intent.putExtra("dato_nombre",nombre);
                    intent.putExtra("dato_apellido",apellido);
                    startActivity(intent);

                }
            }
        });

    }
}