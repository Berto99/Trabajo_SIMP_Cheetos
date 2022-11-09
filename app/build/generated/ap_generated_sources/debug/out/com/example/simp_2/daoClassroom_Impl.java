package com.example.simp_2;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class daoClassroom_Impl implements daoClassroom {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Classroom> __insertionAdapterOfClassroom;

  public daoClassroom_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClassroom = new EntityInsertionAdapter<Classroom>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Classroom` (`id`,`grade`,`name`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Classroom value) {
        stmt.bindLong(1, value.id);
        stmt.bindLong(2, value.getGrade());
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
      }
    };
  }

  @Override
  public void insertarAlumno(final Classroom... classrooms) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfClassroom.insert(classrooms);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Classroom> obtenerClase() {
    final String _sql = "SELECT * FROM Classroom";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfGrade = CursorUtil.getColumnIndexOrThrow(_cursor, "grade");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<Classroom> _result = new ArrayList<Classroom>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Classroom _item;
        final int _tmpGrade;
        _tmpGrade = _cursor.getInt(_cursorIndexOfGrade);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item = new Classroom(_tmpGrade,_tmpName);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
