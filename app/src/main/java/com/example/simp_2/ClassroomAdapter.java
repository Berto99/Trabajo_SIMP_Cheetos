package com.example.simp_2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simp_2.databinding.PrincipalListBinding;

public class ClassroomAdapter extends ListAdapter<Classroom, ClassroomAdapter.ClassroomViewHolder> {

    public static final DiffUtil.ItemCallback<Classroom> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Classroom>() {
                @Override
                public boolean areItemsTheSame(@NonNull Classroom oldClassroom, @NonNull Classroom newClassroom) {
                    return oldClassroom.getName().equals(newClassroom.getName());
                }

                @Override
                public boolean areContentsTheSame(@NonNull Classroom oldClassroom, @NonNull Classroom newClassroom) {
                    return oldClassroom.equals(newClassroom);
                }
            };

    protected ClassroomAdapter() {
        super(DIFF_CALLBACK);
    }

    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener {
        void onItemClick(Classroom classroom);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ClassroomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PrincipalListBinding binding = PrincipalListBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ClassroomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassroomViewHolder holder, int position) {
        Classroom classroom = getItem(position);
        holder.bind(classroom);
    }

    class ClassroomViewHolder extends RecyclerView.ViewHolder {

        private final PrincipalListBinding binding;

        public ClassroomViewHolder(@NonNull PrincipalListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Classroom classroom) {
            binding.gradeText.setText(String.valueOf(classroom.getGrade()));
            binding.classText.setText(String.valueOf(classroom.getName()));

            binding.getRoot().setOnClickListener( v -> {
                onItemClickListener.onItemClick(classroom);
            });
            binding.executePendingBindings();
        }
    }
}
