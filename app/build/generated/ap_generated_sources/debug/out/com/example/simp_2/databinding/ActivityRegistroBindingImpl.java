package com.example.simp_2.databinding;
import com.example.simp_2.R;
import com.example.simp_2.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRegistroBindingImpl extends ActivityRegistroBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.singUp_text, 1);
        sViewsWithIds.put(R.id.username_text_singUp, 2);
        sViewsWithIds.put(R.id.username_edit_singUp, 3);
        sViewsWithIds.put(R.id.password_text_singUp, 4);
        sViewsWithIds.put(R.id.password_edit_singUp, 5);
        sViewsWithIds.put(R.id.name_text, 6);
        sViewsWithIds.put(R.id.name_edit, 7);
        sViewsWithIds.put(R.id.surname_text, 8);
        sViewsWithIds.put(R.id.surname_edit, 9);
        sViewsWithIds.put(R.id.singUp_boton, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRegistroBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityRegistroBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.EditText) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.Button) bindings[10]
            , (android.widget.TextView) bindings[1]
            , (android.widget.EditText) bindings[9]
            , (android.widget.TextView) bindings[8]
            , (android.widget.EditText) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}