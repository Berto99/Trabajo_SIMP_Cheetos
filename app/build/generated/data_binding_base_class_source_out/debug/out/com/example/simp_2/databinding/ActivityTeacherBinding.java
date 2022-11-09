// Generated by data binding compiler. Do not edit!
package com.example.simp_2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.simp_2.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityTeacherBinding extends ViewDataBinding {
  @NonNull
  public final TextView classes;

  @NonNull
  public final TextView emptyView;

  @NonNull
  public final RecyclerView principalRecycler;

  @NonNull
  public final TextView usernameView;

  protected ActivityTeacherBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView classes, TextView emptyView, RecyclerView principalRecycler, TextView usernameView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.classes = classes;
    this.emptyView = emptyView;
    this.principalRecycler = principalRecycler;
    this.usernameView = usernameView;
  }

  @NonNull
  public static ActivityTeacherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_teacher, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTeacherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityTeacherBinding>inflateInternal(inflater, R.layout.activity_teacher, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTeacherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_teacher, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTeacherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityTeacherBinding>inflateInternal(inflater, R.layout.activity_teacher, null, false, component);
  }

  public static ActivityTeacherBinding bind(@NonNull View view) {
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
  public static ActivityTeacherBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityTeacherBinding)bind(component, view, R.layout.activity_teacher);
  }
}
