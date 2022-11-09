package com.example.simp_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.simp_2.databinding.ActivityStudentsBinding;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStudentsBinding binding = ActivityStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Variables
        Button boton =findViewById(R.id.new_student);

        //Acceder BBDD
        AppData appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppData.class,
                "Simp_BD"
        ).allowMainThreadQueries().build();



        binding.principalStudentsRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Student> studentsList = new ArrayList<>();


        List<Classroom> clase;

        //studentsList.add(new Student(1, "Juan Fernández Hinojar",2));

        StudentAdapter adapter = new StudentAdapter();
        binding.principalStudentsRecycler.setAdapter(adapter);
        adapter.submitList(studentsList);

        if (studentsList.isEmpty()) {
            binding.emptyStudentsView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyStudentsView.setVisibility(View.GONE);
        }


        boton.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddStudentActivity.class);
            startActivity(intent);
        });



    }
}
