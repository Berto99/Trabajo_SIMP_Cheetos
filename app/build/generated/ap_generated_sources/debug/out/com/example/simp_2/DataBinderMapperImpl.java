package com.example.simp_2;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.simp_2.databinding.ActivityAddClassBindingImpl;
import com.example.simp_2.databinding.ActivityAddClassBindingNightImpl;
import com.example.simp_2.databinding.ActivityAddStudentBindingImpl;
import com.example.simp_2.databinding.ActivityAddStudentBindingNightImpl;
import com.example.simp_2.databinding.ActivityMainBindingImpl;
import com.example.simp_2.databinding.ActivityMainBindingLandImpl;
import com.example.simp_2.databinding.ActivityMainBindingLandNightImpl;
import com.example.simp_2.databinding.ActivityMainBindingNightImpl;
import com.example.simp_2.databinding.ActivityRegistroBindingImpl;
import com.example.simp_2.databinding.ActivityRegistroBindingNightImpl;
import com.example.simp_2.databinding.ActivityStudentsBindingImpl;
import com.example.simp_2.databinding.ActivityStudentsBindingLandImpl;
import com.example.simp_2.databinding.ActivityStudentsBindingLandNightImpl;
import com.example.simp_2.databinding.ActivityStudentsBindingNightImpl;
import com.example.simp_2.databinding.ActivityTeacherBindingImpl;
import com.example.simp_2.databinding.ActivityTeacherBindingLandImpl;
import com.example.simp_2.databinding.ActivityTeacherBindingLandNightImpl;
import com.example.simp_2.databinding.ActivityTeacherBindingNightImpl;
import com.example.simp_2.databinding.ActivityTotalBindingImpl;
import com.example.simp_2.databinding.PrincipalListBindingImpl;
import com.example.simp_2.databinding.StudentListBindingImpl;
import com.example.simp_2.databinding.StudentListBindingLandImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDCLASS = 1;

  private static final int LAYOUT_ACTIVITYADDSTUDENT = 2;

  private static final int LAYOUT_ACTIVITYMAIN = 3;

  private static final int LAYOUT_ACTIVITYREGISTRO = 4;

  private static final int LAYOUT_ACTIVITYSTUDENTS = 5;

  private static final int LAYOUT_ACTIVITYTEACHER = 6;

  private static final int LAYOUT_ACTIVITYTOTAL = 7;

  private static final int LAYOUT_PRINCIPALLIST = 8;

  private static final int LAYOUT_STUDENTLIST = 9;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(9);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.activity_add_class, LAYOUT_ACTIVITYADDCLASS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.activity_add_student, LAYOUT_ACTIVITYADDSTUDENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.activity_registro, LAYOUT_ACTIVITYREGISTRO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.activity_students, LAYOUT_ACTIVITYSTUDENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.activity_teacher, LAYOUT_ACTIVITYTEACHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.activity_total, LAYOUT_ACTIVITYTOTAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.principal_list, LAYOUT_PRINCIPALLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.simp_2.R.layout.student_list, LAYOUT_STUDENTLIST);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADDCLASS: {
          if ("layout/activity_add_class_0".equals(tag)) {
            return new ActivityAddClassBindingImpl(component, view);
          }
          if ("layout-night/activity_add_class_0".equals(tag)) {
            return new ActivityAddClassBindingNightImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_class is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYADDSTUDENT: {
          if ("layout/activity_add_student_0".equals(tag)) {
            return new ActivityAddStudentBindingImpl(component, view);
          }
          if ("layout-night/activity_add_student_0".equals(tag)) {
            return new ActivityAddStudentBindingNightImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_student is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          if ("layout-night/activity_main_0".equals(tag)) {
            return new ActivityMainBindingNightImpl(component, view);
          }
          if ("layout-land/activity_main_0".equals(tag)) {
            return new ActivityMainBindingLandImpl(component, view);
          }
          if ("layout-land-night/activity_main_0".equals(tag)) {
            return new ActivityMainBindingLandNightImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTRO: {
          if ("layout/activity_registro_0".equals(tag)) {
            return new ActivityRegistroBindingImpl(component, view);
          }
          if ("layout-night/activity_registro_0".equals(tag)) {
            return new ActivityRegistroBindingNightImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_registro is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTS: {
          if ("layout-land-night/activity_students_0".equals(tag)) {
            return new ActivityStudentsBindingLandNightImpl(component, view);
          }
          if ("layout-night/activity_students_0".equals(tag)) {
            return new ActivityStudentsBindingNightImpl(component, view);
          }
          if ("layout/activity_students_0".equals(tag)) {
            return new ActivityStudentsBindingImpl(component, view);
          }
          if ("layout-land/activity_students_0".equals(tag)) {
            return new ActivityStudentsBindingLandImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_students is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTEACHER: {
          if ("layout-land/activity_teacher_0".equals(tag)) {
            return new ActivityTeacherBindingLandImpl(component, view);
          }
          if ("layout/activity_teacher_0".equals(tag)) {
            return new ActivityTeacherBindingImpl(component, view);
          }
          if ("layout-night/activity_teacher_0".equals(tag)) {
            return new ActivityTeacherBindingNightImpl(component, view);
          }
          if ("layout-land-night/activity_teacher_0".equals(tag)) {
            return new ActivityTeacherBindingLandNightImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_teacher is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYTOTAL: {
          if ("layout/activity_total_0".equals(tag)) {
            return new ActivityTotalBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_total is invalid. Received: " + tag);
        }
        case  LAYOUT_PRINCIPALLIST: {
          if ("layout/principal_list_0".equals(tag)) {
            return new PrincipalListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for principal_list is invalid. Received: " + tag);
        }
        case  LAYOUT_STUDENTLIST: {
          if ("layout-land/student_list_0".equals(tag)) {
            return new StudentListBindingLandImpl(component, view);
          }
          if ("layout/student_list_0".equals(tag)) {
            return new StudentListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for student_list is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(22);

    static {
      sKeys.put("layout/activity_add_class_0", com.example.simp_2.R.layout.activity_add_class);
      sKeys.put("layout-night/activity_add_class_0", com.example.simp_2.R.layout.activity_add_class);
      sKeys.put("layout/activity_add_student_0", com.example.simp_2.R.layout.activity_add_student);
      sKeys.put("layout-night/activity_add_student_0", com.example.simp_2.R.layout.activity_add_student);
      sKeys.put("layout/activity_main_0", com.example.simp_2.R.layout.activity_main);
      sKeys.put("layout-night/activity_main_0", com.example.simp_2.R.layout.activity_main);
      sKeys.put("layout-land/activity_main_0", com.example.simp_2.R.layout.activity_main);
      sKeys.put("layout-land-night/activity_main_0", com.example.simp_2.R.layout.activity_main);
      sKeys.put("layout/activity_registro_0", com.example.simp_2.R.layout.activity_registro);
      sKeys.put("layout-night/activity_registro_0", com.example.simp_2.R.layout.activity_registro);
      sKeys.put("layout-land-night/activity_students_0", com.example.simp_2.R.layout.activity_students);
      sKeys.put("layout-night/activity_students_0", com.example.simp_2.R.layout.activity_students);
      sKeys.put("layout/activity_students_0", com.example.simp_2.R.layout.activity_students);
      sKeys.put("layout-land/activity_students_0", com.example.simp_2.R.layout.activity_students);
      sKeys.put("layout-land/activity_teacher_0", com.example.simp_2.R.layout.activity_teacher);
      sKeys.put("layout/activity_teacher_0", com.example.simp_2.R.layout.activity_teacher);
      sKeys.put("layout-night/activity_teacher_0", com.example.simp_2.R.layout.activity_teacher);
      sKeys.put("layout-land-night/activity_teacher_0", com.example.simp_2.R.layout.activity_teacher);
      sKeys.put("layout/activity_total_0", com.example.simp_2.R.layout.activity_total);
      sKeys.put("layout/principal_list_0", com.example.simp_2.R.layout.principal_list);
      sKeys.put("layout-land/student_list_0", com.example.simp_2.R.layout.student_list);
      sKeys.put("layout/student_list_0", com.example.simp_2.R.layout.student_list);
    }
  }
}
