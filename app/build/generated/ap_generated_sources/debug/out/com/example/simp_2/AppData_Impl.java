package com.example.simp_2;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppData_Impl extends AppData {
  private volatile daoUsuario _daoUsuario;

  private volatile daoClassroom _daoClassroom;

  private volatile daoStudent _daoStudent;

  private volatile daoFaltas _daoFaltas;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Usuario` (`usuario` TEXT NOT NULL, `contrasena` TEXT, `nombre` TEXT, `apellido` TEXT, PRIMARY KEY(`usuario`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Classroom` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fk_usuario` TEXT, `grade` INTEGER NOT NULL, `name` TEXT, FOREIGN KEY(`fk_usuario`) REFERENCES `Usuario`(`usuario`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Student` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fk_clase` INTEGER NOT NULL, `number_list` INTEGER NOT NULL, `name` TEXT, FOREIGN KEY(`fk_clase`) REFERENCES `Classroom`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Faltas` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fk_id_alumno` INTEGER NOT NULL, `fk_usuario` TEXT, `fecha` INTEGER, FOREIGN KEY(`fk_id_alumno`) REFERENCES `Student`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`fk_usuario`) REFERENCES `Usuario`(`usuario`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ca6f393202ff9a06676aef11d279697d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Usuario`");
        _db.execSQL("DROP TABLE IF EXISTS `Classroom`");
        _db.execSQL("DROP TABLE IF EXISTS `Student`");
        _db.execSQL("DROP TABLE IF EXISTS `Faltas`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsuario = new HashMap<String, TableInfo.Column>(4);
        _columnsUsuario.put("usuario", new TableInfo.Column("usuario", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuario.put("contrasena", new TableInfo.Column("contrasena", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuario.put("nombre", new TableInfo.Column("nombre", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuario.put("apellido", new TableInfo.Column("apellido", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsuario = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsuario = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsuario = new TableInfo("Usuario", _columnsUsuario, _foreignKeysUsuario, _indicesUsuario);
        final TableInfo _existingUsuario = TableInfo.read(_db, "Usuario");
        if (! _infoUsuario.equals(_existingUsuario)) {
          return new RoomOpenHelper.ValidationResult(false, "Usuario(com.example.simp_2.Usuario).\n"
                  + " Expected:\n" + _infoUsuario + "\n"
                  + " Found:\n" + _existingUsuario);
        }
        final HashMap<String, TableInfo.Column> _columnsClassroom = new HashMap<String, TableInfo.Column>(4);
        _columnsClassroom.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClassroom.put("fk_usuario", new TableInfo.Column("fk_usuario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClassroom.put("grade", new TableInfo.Column("grade", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClassroom.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClassroom = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysClassroom.add(new TableInfo.ForeignKey("Usuario", "NO ACTION", "NO ACTION",Arrays.asList("fk_usuario"), Arrays.asList("usuario")));
        final HashSet<TableInfo.Index> _indicesClassroom = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClassroom = new TableInfo("Classroom", _columnsClassroom, _foreignKeysClassroom, _indicesClassroom);
        final TableInfo _existingClassroom = TableInfo.read(_db, "Classroom");
        if (! _infoClassroom.equals(_existingClassroom)) {
          return new RoomOpenHelper.ValidationResult(false, "Classroom(com.example.simp_2.Classroom).\n"
                  + " Expected:\n" + _infoClassroom + "\n"
                  + " Found:\n" + _existingClassroom);
        }
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(4);
        _columnsStudent.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("fk_clase", new TableInfo.Column("fk_clase", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("number_list", new TableInfo.Column("number_list", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudent = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysStudent.add(new TableInfo.ForeignKey("Classroom", "NO ACTION", "NO ACTION",Arrays.asList("fk_clase"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesStudent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudent = new TableInfo("Student", _columnsStudent, _foreignKeysStudent, _indicesStudent);
        final TableInfo _existingStudent = TableInfo.read(_db, "Student");
        if (! _infoStudent.equals(_existingStudent)) {
          return new RoomOpenHelper.ValidationResult(false, "Student(com.example.simp_2.Student).\n"
                  + " Expected:\n" + _infoStudent + "\n"
                  + " Found:\n" + _existingStudent);
        }
        final HashMap<String, TableInfo.Column> _columnsFaltas = new HashMap<String, TableInfo.Column>(4);
        _columnsFaltas.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFaltas.put("fk_id_alumno", new TableInfo.Column("fk_id_alumno", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFaltas.put("fk_usuario", new TableInfo.Column("fk_usuario", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFaltas.put("fecha", new TableInfo.Column("fecha", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFaltas = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysFaltas.add(new TableInfo.ForeignKey("Student", "NO ACTION", "NO ACTION",Arrays.asList("fk_id_alumno"), Arrays.asList("id")));
        _foreignKeysFaltas.add(new TableInfo.ForeignKey("Usuario", "NO ACTION", "NO ACTION",Arrays.asList("fk_usuario"), Arrays.asList("usuario")));
        final HashSet<TableInfo.Index> _indicesFaltas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFaltas = new TableInfo("Faltas", _columnsFaltas, _foreignKeysFaltas, _indicesFaltas);
        final TableInfo _existingFaltas = TableInfo.read(_db, "Faltas");
        if (! _infoFaltas.equals(_existingFaltas)) {
          return new RoomOpenHelper.ValidationResult(false, "Faltas(com.example.simp_2.Faltas).\n"
                  + " Expected:\n" + _infoFaltas + "\n"
                  + " Found:\n" + _existingFaltas);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ca6f393202ff9a06676aef11d279697d", "a9fefce27bf7770dadbb0eafaf052955");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Usuario","Classroom","Student","Faltas");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Faltas`");
      _db.execSQL("DELETE FROM `Student`");
      _db.execSQL("DELETE FROM `Classroom`");
      _db.execSQL("DELETE FROM `Usuario`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(daoUsuario.class, daoUsuario_Impl.getRequiredConverters());
    _typeConvertersMap.put(daoClassroom.class, daoClassroom_Impl.getRequiredConverters());
    _typeConvertersMap.put(daoStudent.class, daoStudent_Impl.getRequiredConverters());
    _typeConvertersMap.put(daoFaltas.class, daoFaltas_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public daoUsuario DAOusuario() {
    if (_daoUsuario != null) {
      return _daoUsuario;
    } else {
      synchronized(this) {
        if(_daoUsuario == null) {
          _daoUsuario = new daoUsuario_Impl(this);
        }
        return _daoUsuario;
      }
    }
  }

  @Override
  public daoClassroom DAOClassroom() {
    if (_daoClassroom != null) {
      return _daoClassroom;
    } else {
      synchronized(this) {
        if(_daoClassroom == null) {
          _daoClassroom = new daoClassroom_Impl(this);
        }
        return _daoClassroom;
      }
    }
  }

  @Override
  public daoStudent DAOStudent() {
    if (_daoStudent != null) {
      return _daoStudent;
    } else {
      synchronized(this) {
        if(_daoStudent == null) {
          _daoStudent = new daoStudent_Impl(this);
        }
        return _daoStudent;
      }
    }
  }

  @Override
  public daoFaltas DAOFaltas() {
    if (_daoFaltas != null) {
      return _daoFaltas;
    } else {
      synchronized(this) {
        if(_daoFaltas == null) {
          _daoFaltas = new daoFaltas_Impl(this);
        }
        return _daoFaltas;
      }
    }
  }
}
