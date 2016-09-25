package v1.forestapp.com.forestapp.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import v1.forestapp.com.forestapp.DTO.ArbolDTO;
import v1.forestapp.com.forestapp.DTO.SabiasDTO;

public class DataBaseManager {
    private AdminSQLiteOpenHelper helper;
    private  SQLiteDatabase db;
    //----------------------------------TABLA 1----------------------------------------------
    public static  final String TABLA_1="Arboles"; // Nombre de la tabla

    public static  final String TABLA_1_CAMPO_1="Id";
    public static  final String TABLA_1_CAMPO_2="NombreComun";
    public static  final String TABLA_1_CAMPO_3="NombreCientifico";
    public static  final String TABLA_1_CAMPO_4="Reino";
    public static  final String TABLA_1_CAMPO_5="Filo";
    public static  final String TABLA_1_CAMPO_6="Clase";
    public static  final String TABLA_1_CAMPO_7="Fruto";
    public static  final String TABLA_1_CAMPO_8="Flor";
    public static  final String TABLA_1_CAMPO_9="Descripcion";
    public static  final String TABLA_1_CAMPO_10="Imagen";

    public static  final String CREATE_TABLE_1 = "create table " + TABLA_1 + " ("

            + TABLA_1_CAMPO_2 + " text not null, "
            + TABLA_1_CAMPO_3 + " text not null, "
            + TABLA_1_CAMPO_4 + " text not null, "
            + TABLA_1_CAMPO_5 + " text not null, "
            + TABLA_1_CAMPO_6 + " text not null, "
            + TABLA_1_CAMPO_7 + " text not null, "
            + TABLA_1_CAMPO_8 + " text not null, "
            + TABLA_1_CAMPO_9 + " text not null, "
            + TABLA_1_CAMPO_10 + " integer); ";



    private ContentValues GenerarContentValuesArboles(ArbolDTO m) {
        ContentValues valores = new ContentValues();
        valores.put(TABLA_1_CAMPO_2, m.getNombreComun());
        valores.put(TABLA_1_CAMPO_3, m.getNombreCientifico());
        valores.put(TABLA_1_CAMPO_4, m.getReino());
        valores.put(TABLA_1_CAMPO_5, m.getFilo());
        valores.put(TABLA_1_CAMPO_6, m.getClase());
        valores.put(TABLA_1_CAMPO_7, m.getFruto());
        valores.put(TABLA_1_CAMPO_8, m.getFlor());
        valores.put(TABLA_1_CAMPO_9, m.getDescripcion());
        valores.put(TABLA_1_CAMPO_10, m.getImagen());
        return valores;
    }

    public void InsertarArboles(ArbolDTO m) {
        db.insert(TABLA_1, null, GenerarContentValuesArboles(m));
    }
    public void ActualizarArboles (ArbolDTO m, String nombre){
        ContentValues valores = new ContentValues();
        valores.put(TABLA_1_CAMPO_2, m.getNombreComun());
        valores.put(TABLA_1_CAMPO_3, m.getNombreCientifico());
        valores.put(TABLA_1_CAMPO_4, m.getReino());
        valores.put(TABLA_1_CAMPO_5, m.getFilo());
        valores.put(TABLA_1_CAMPO_6, m.getClase());
        valores.put(TABLA_1_CAMPO_7, m.getFruto());
        valores.put(TABLA_1_CAMPO_8, m.getFlor());
        valores.put(TABLA_1_CAMPO_9, m.getDescripcion());
        db.update(TABLA_1, valores,TABLA_1_CAMPO_2 +  " = " + nombre, null);
    }

    public void EliminarArboles (String nombre){
        db.delete(TABLA_1,TABLA_1_CAMPO_2 +  " = " + nombre, null);
    }

    public ArbolDTO getArbol(String nombre){

        ArbolDTO m = null;
        Cursor c = db.rawQuery(" SELECT " + TABLA_1_CAMPO_2 + " , "+ TABLA_1_CAMPO_3 + " ,"
                + TABLA_1_CAMPO_4 + " , "+ TABLA_1_CAMPO_5 + " , " + TABLA_1_CAMPO_6 + " , "
                + TABLA_1_CAMPO_7 + " , " + TABLA_1_CAMPO_8 + " , " + TABLA_1_CAMPO_9 + " , " + TABLA_1_CAMPO_10 + " FROM " + TABLA_1 + " where " + TABLA_1_CAMPO_2 + " = '" + nombre + "'", null);
        if (c.moveToFirst()) {
            m = new ArbolDTO();
            m.setNombreComun(c.getString(0));
            m.setNombreCientifico(c.getString(1));
            m.setReino(c.getString(2));
            m.setFilo(c.getString(3));
            m.setClase(c.getString(4));
            m.setFruto(c.getString(5));
            m.setFlor(c.getString(6));
            m.setDescripcion(c.getString(7));
            m.setImagen(c.getInt(8));
        }
        return m;
    }

    public ArrayList<ArbolDTO> getListaArboles(){
        Cursor c = db.rawQuery(" SELECT " + TABLA_1_CAMPO_2 + " , "+ TABLA_1_CAMPO_3+" ,"
                + TABLA_1_CAMPO_4 + " , "+ TABLA_1_CAMPO_5 + " , " + TABLA_1_CAMPO_6 + " , "
                + TABLA_1_CAMPO_7 + " , " + TABLA_1_CAMPO_8 + " , " + TABLA_1_CAMPO_9 + " , " + TABLA_1_CAMPO_10 + " FROM " + TABLA_1, null);
        ArrayList<ArbolDTO> Lista = new ArrayList<ArbolDTO>();
        while (c.moveToNext()){
            ArbolDTO m = new ArbolDTO();
            m.setNombreComun(c.getString(0));
            m.setNombreCientifico(c.getString(1));
            m.setReino(c.getString(2));
            m.setFilo(c.getString(3));
            m.setClase(c.getString(4));
            m.setFruto(c.getString(5));
            m.setFlor(c.getString(6));
            m.setDescripcion(c.getString(7));
            m.setImagen(c.getInt(8));
            Lista.add(m);
        }
        return Lista;
    }

    public void deleteTodoArboles() {
        db.execSQL("DELETE FROM " + TABLA_1);
    }

    ///////////////////////////////////////////////////////////////////////////////////

    //---------------------------------- TABLA 2 --------------------------------------------
    public  static final String TABLA_2="Sabias"; //Nombre de la tabla

    public static final String TABLA_2_CAMPO_1="Nombre";
    public static final String TABLA_2_CAMPO_2="Descripcion";
    public static final String TABLA_2_CAMPO_3="Imagen";

    public static  final String CREATE_TABLE_2 = "create table " + TABLA_2 + " ("

            + TABLA_2_CAMPO_1 + " text not null, "
            + TABLA_2_CAMPO_2 + " text not null, "
            + TABLA_2_CAMPO_3 + " integer); ";

    public DataBaseManager(Context context) {
        helper = new AdminSQLiteOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues GenerarContentValuesSabias(SabiasDTO m) {
        ContentValues valores = new ContentValues();
        valores.put(TABLA_2_CAMPO_1, m.getNombre());
        valores.put(TABLA_2_CAMPO_2, m.getDescripcion());
        valores.put(TABLA_2_CAMPO_3, m.getImagen());
        return valores;
    }

    public void InsertarSabias(SabiasDTO m) {
        db.insert(TABLA_2, null, GenerarContentValuesSabias(m));
    }

    public void ActualizarSabias (SabiasDTO m, String nombre){
        ContentValues valores = new ContentValues();
        valores.put(TABLA_2_CAMPO_1, m.getNombre());
        valores.put(TABLA_2_CAMPO_2, m.getDescripcion());

        db.update(TABLA_2, valores,TABLA_2_CAMPO_1 +  " = " + nombre, null);
    }

    public void EliminarSabias (String nombre) {
        db.delete(TABLA_2, TABLA_2_CAMPO_1 + " = " + nombre, null);
    }

    public SabiasDTO getSabias(String nombre){

        SabiasDTO m = null;
        Cursor c = db.rawQuery(" SELECT " + TABLA_2_CAMPO_1 + " , "+ TABLA_2_CAMPO_2 + " ,"
                + TABLA_2_CAMPO_3 + " FROM " + TABLA_2 + " where " + TABLA_2_CAMPO_2 + " = '" + nombre + "'", null);
        if (c.moveToFirst()) {
            m = new SabiasDTO();
            m.setNombre(c.getString(0));
            m.setDescripcion(c.getString(1));
            m.setImagen(c.getInt(2));
        }
        return m;
    }

    public ArrayList<SabiasDTO> getListaSabias(){
        Cursor c = db.rawQuery(" SELECT " + TABLA_2_CAMPO_1 + " , "+ TABLA_2_CAMPO_2+" ,"
                + TABLA_2_CAMPO_3 + " FROM " + TABLA_2, null);
        ArrayList<SabiasDTO> Lista = new ArrayList<SabiasDTO>();
        while (c.moveToNext()){
            SabiasDTO m = new SabiasDTO();
            m.setNombre(c.getString(0));
            m.setDescripcion(c.getString(1));
            m.setImagen(c.getInt(2));
            Lista.add(m);
        }
        return Lista;
    }

    public void deleteTodoSabias() {
        db.execSQL("DELETE FROM " + TABLA_2);
    }


}
