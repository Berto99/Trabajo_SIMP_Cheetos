package com.example.simp_2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.simp_2.databinding.ActivityStudentsBinding;

import java.util.ArrayList;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStudentsBinding binding = ActivityStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.principalStudentsRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student(1, "Juan Fernández Hinojar"));
        studentsList.add(new Student(2, "Ismael López Gordillo"));
        studentsList.add(new Student(3, "Adrián Cortés de Dios"));
        studentsList.add(new Student(4, "Alberto Ruiz Moyano"));
        studentsList.add(new Student(5, "Alberto Ruiz Moyano"));
        studentsList.add(new Student(6, "Alberto Ruiz Moyano"));
        studentsList.add(new Student(7, "Alberto Ruiz Moyano"));
        studentsList.add(new Student(8, "Alberto Ruiz Moyano"));
        studentsList.add(new Student(9, "Alberto Ruiz Moyano"));

        StudentAdapter adapter = new StudentAdapter();
        binding.principalStudentsRecycler.setAdapter(adapter);
        adapter.submitList(studentsList);

        if (studentsList.isEmpty()) {
            binding.emptyStudentsView.setVisibility(View.VISIBLE);
        }else{
            binding.emptyStudentsView.setVisibility(View.GONE);
        }

    }
}
