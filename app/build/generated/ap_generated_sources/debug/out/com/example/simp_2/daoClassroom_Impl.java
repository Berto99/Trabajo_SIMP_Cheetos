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
        return "INSERT OR ABORT INTO `Classroom` (`id`,`fk_usuario`,`grade`,`name`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Classroom value) {
        stmt.bindLong(1, value.getId());
        if (value.getFk_usuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFk_usuario());
        }
        stmt.bindLong(3, value.getGrade());
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
      }
    };
  }

  @Override
  public void insertarClase(final Classroom... classrooms) {
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
      final int _cursorIndexOfFkUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "fk_usuario");
      final int _cursorIndexOfGrade = CursorUtil.getColumnIndexOrThrow(_cursor, "grade");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<Classroom> _result = new ArrayList<Classroom>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Classroom _item;
        _item = new Classroom();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpFk_usuario;
        if (_cursor.isNull(_cursorIndexOfFkUsuario)) {
          _tmpFk_usuario = null;
        } else {
          _tmpFk_usuario = _cursor.getString(_cursorIndexOfFkUsuario);
        }
        _item.setFk_usuario(_tmpFk_usuario);
        final int _tmpGrade;
        _tmpGrade = _cursor.getInt(_cursorIndexOfGrade);
        _item.setGrade(_tmpGrade);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int obteneridClase() {
    final String _sql = "SELECT id FROM Classroom";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
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
