package com.example.simp_2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simp_2.databinding.StudentListBinding;

public class StudentAdapter extends ListAdapter<Student, StudentAdapter.StudentViewHolder> {

    public static final DiffUtil.ItemCallback<Student> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Student>() {
                @Override
                public boolean areItemsTheSame(@NonNull Student oldStudent, @NonNull Student newStudent) {
                    return oldStudent.getName().equals(newStudent.getName());
                }

                @Override
                public boolean areContentsTheSame(@NonNull Student oldStudent, @NonNull Student newStudent) {
                    return oldStudent.equals(newStudent);
                }
            };

    protected StudentAdapter() {
        super(DIFF_CALLBACK);
    }

    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener {
        void onItemClick(Student student);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StudentListBinding binding = StudentListBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new StudentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
        Student student = getItem(position);
        holder.bind(student);
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        private final StudentListBinding binding;

        public StudentViewHolder(StudentListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Student student){
            binding.nameStudentText.setText(String.valueOf(student.getName()));
            binding.getRoot().setOnClickListener( v -> {
                onItemClickListener.onItemClick(student);
            });
            binding.executePendingBindings();
        }
    }
}
