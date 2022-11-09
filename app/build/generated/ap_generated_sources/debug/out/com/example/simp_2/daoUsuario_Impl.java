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
public final class daoUsuario_Impl implements daoUsuario {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Usuario> __insertionAdapterOfUsuario;

  public daoUsuario_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsuario = new EntityInsertionAdapter<Usuario>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Usuario` (`usuario`,`contrasena`,`nombre`,`apellido`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Usuario value) {
        if (value.usuario == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.usuario);
        }
        if (value.contrasena == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.contrasena);
        }
        if (value.nombre == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.nombre);
        }
        if (value.apellido == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.apellido);
        }
      }
    };
  }

  @Override
  public void insertarUsuario(final Usuario... usuarios) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUsuario.insert(usuarios);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Usuario> obtenerUsuarios() {
    final String _sql = "SELECT * FROM Usuario";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
      final int _cursorIndexOfContrasena = CursorUtil.getColumnIndexOrThrow(_cursor, "contrasena");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfApellido = CursorUtil.getColumnIndexOrThrow(_cursor, "apellido");
      final List<Usuario> _result = new ArrayList<Usuario>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Usuario _item;
        final String _tmpUsuario;
        if (_cursor.isNull(_cursorIndexOfUsuario)) {
          _tmpUsuario = null;
        } else {
          _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
        }
        final String _tmpContrasena;
        if (_cursor.isNull(_cursorIndexOfContrasena)) {
          _tmpContrasena = null;
        } else {
          _tmpContrasena = _cursor.getString(_cursorIndexOfContrasena);
        }
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpApellido;
        if (_cursor.isNull(_cursorIndexOfApellido)) {
          _tmpApellido = null;
        } else {
          _tmpApellido = _cursor.getString(_cursorIndexOfApellido);
        }
        _item = new Usuario(_tmpUsuario,_tmpContrasena,_tmpNombre,_tmpApellido);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Usuario> obtenerUsuarioEspecifico(final String usuario) {
    final String _sql = "SELECT * FROM Usuario where usuario = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuario);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
      final int _cursorIndexOfContrasena = CursorUtil.getColumnIndexOrThrow(_cursor, "contrasena");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfApellido = CursorUtil.getColumnIndexOrThrow(_cursor, "apellido");
      final List<Usuario> _result = new ArrayList<Usuario>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Usuario _item;
        final String _tmpUsuario;
        if (_cursor.isNull(_cursorIndexOfUsuario)) {
          _tmpUsuario = null;
        } else {
          _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
        }
        final String _tmpContrasena;
        if (_cursor.isNull(_cursorIndexOfContrasena)) {
          _tmpContrasena = null;
        } else {
          _tmpContrasena = _cursor.getString(_cursorIndexOfContrasena);
        }
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpApellido;
        if (_cursor.isNull(_cursorIndexOfApellido)) {
          _tmpApellido = null;
        } else {
          _tmpApellido = _cursor.getString(_cursorIndexOfApellido);
        }
        _item = new Usuario(_tmpUsuario,_tmpContrasena,_tmpNombre,_tmpApellido);
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
