package com.example.simp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class TotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        //Variables
        TextView texto_alumno=findViewById(R.id.name_total);
        String alumno;

        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();

        Bundle extras =getIntent().getExtras();
        alumno = extras.getString("dato_alumno");
        texto_alumno.setText(alumno);



    }
}