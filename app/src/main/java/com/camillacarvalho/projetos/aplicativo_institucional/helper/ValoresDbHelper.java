package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.camillacarvalho.projetos.aplicativo_institucional.model.Valores;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Visao;

public class ValoresDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Valores.db";
    public static final int DATABASE_VERSION = 1;

    public final String CREATE = "create table " + ValoresContract.ValoresDb.TABLE_NAME +"( "
            + ValoresContract.ValoresDb._ID + " integer primary key autoincrement, "
            + ValoresContract.ValoresDb.TITULO + " text, "
            + ValoresContract.ValoresDb.CONTEUDO + " text)";

    private final String DELETE = "drop table if exists " + ValoresContract.ValoresDb.TABLE_NAME;

    public ValoresDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(this.DELETE);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

    public void inserirValores(){
        // inserir dados da valores
        SQLiteDatabase sqLiteDatabaseWritable = this.getWritableDatabase();
        ContentValues cvs = new ContentValues();
        cvs.put(ValoresContract.ValoresDb.TITULO, "## NOSSOS VALORES ##");
        cvs.put(ValoresContract.ValoresDb.CONTEUDO, "Nossos valores são baseados nos pilares: transparência e confiabilidade nas relações e nos projetos.");
        sqLiteDatabaseWritable.insert(ValoresContract.ValoresDb.TABLE_NAME,null, cvs);
    }

    @SuppressLint("Range")
    public Valores consultarValores() {
        Valores valores = null;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "
                + ValoresContract.ValoresDb.TABLE_NAME, null);
        while(cursor.moveToNext()){
            long _id = (cursor.getLong(cursor.getColumnIndex(ValoresContract.ValoresDb._ID)));
            String título = (cursor.getString(cursor.getColumnIndex(ValoresContract.ValoresDb.TITULO)));
            String conteudo = (cursor.getString(cursor.getColumnIndex(ValoresContract.ValoresDb.CONTEUDO)));

            valores = new Valores(_id, título, conteudo);
        }
        return valores;
    }

}
