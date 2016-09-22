package v1.forestapp.com.forestapp.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private  static  final String DB_NAME ="Arboles";
    private  static  final int DB_SCHEME_VERSION=12;

    public AdminSQLiteOpenHelper(Context context) {
        super(context, DB_NAME,null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE_1);
        db.execSQL(DataBaseManager.CREATE_TABLE_2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DataBaseManager.TABLA_1);
        db.execSQL("DROP TABLE IF EXISTS "+ DataBaseManager.TABLA_2);
        db.execSQL(DataBaseManager.CREATE_TABLE_1);
        db.execSQL(DataBaseManager.CREATE_TABLE_2);

    }
}
