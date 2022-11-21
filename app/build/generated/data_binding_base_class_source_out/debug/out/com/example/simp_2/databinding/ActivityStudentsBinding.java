// Generated by data binding compiler. Do not edit!
package com.example.simp_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.simp_2.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityStudentsBinding extends ViewDataBinding {
  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   *   <li>layout-land-night/</li>
   *   <li>layout-night/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final ImageButton backButtonSingUp;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout-land/</li>
   *   <li>layout-land-night/</li>
   *   <li>layout-night/</li>
   * </ul>
   */
  @Nullable
  public final ImageButton backButtonStudents;

  @NonNull
  public final TextView chosenClass;

  @NonNull
  public final TextView emptyStudentsView;

  @NonNull
  public final Button newStudent;

  @NonNull
  public final RecyclerView principalStudentsRecycler;

  @NonNull
  public final Button saveFaults;

  @NonNull
  public final TextView usernameStudentsView;

  protected ActivityStudentsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageButton backButtonSingUp, ImageButton backButtonStudents, TextView chosenClass,
      TextView emptyStudentsView, Button newStudent, RecyclerView principalStudentsRecycler,
      Button saveFaults, TextView usernameStudentsView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.backButtonSingUp = backButtonSingUp;
    this.backButtonStudents = backButtonStudents;
    this.chosenClass = chosenClass;
    this.emptyStudentsView = emptyStudentsView;
    this.newStudent = newStudent;
    this.principalStudentsRecycler = principalStudentsRecycler;
    this.saveFaults = saveFaults;
    this.usernameStudentsView = usernameStudentsView;
  }

  @NonNull
  public static ActivityStudentsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_students, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStudentsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityStudentsBinding>inflateInternal(inflater, R.layout.activity_students, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityStudentsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_students, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityStudentsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityStudentsBinding>inflateInternal(inflater, R.layout.activity_students, null, false, component);
  }

  public static ActivityStudentsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityStudentsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityStudentsBinding)bind(component, view, R.layout.activity_students);
  }
}
