package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.camillacarvalho.projetos.aplicativo_institucional.model.Home;

import java.util.ArrayList;
import java.util.Currency;

public class HomeDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Home.db";
    public static final int DATABASE_VERSION = 1;

    public final String CREATE = "create table " + HomeContract.HomeDb.TABLE_NAME +" ( "
            + HomeContract.HomeDb._ID + " integer primary key autoincrement, "
            + HomeContract.HomeDb.TITULO + " text, "
            + HomeContract.HomeDb.CONTEUDO + " text)";

    private final String DELETE = "drop table if exists " + HomeContract.HomeDb.TABLE_NAME;

    public HomeDbHelper(@Nullable Context context) {
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

    public void inserirHome(){
        // inserir dados da home
        SQLiteDatabase sqLiteDatabaseWritable = this.getWritableDatabase();
        ContentValues cvs = new ContentValues();
        cvs.put(HomeContract.HomeDb.TITULO, "## HOME ##");
        cvs.put(HomeContract.HomeDb.CONTEUDO, "Bem-vindo(a) à Home!");
        sqLiteDatabaseWritable.insert(HomeContract.HomeDb.TABLE_NAME,null, cvs);
    }

    @SuppressLint("Range")
    public Home consultarHome(){

        Home home = null;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "
                + HomeContract.HomeDb.TABLE_NAME, null);
        while(cursor.moveToNext()){
            long _id = (cursor.getLong(cursor.getColumnIndex(HomeContract.HomeDb._ID)));
            String título = (cursor.getString(cursor.getColumnIndex(HomeContract.HomeDb.TITULO)));
            String conteudo = (cursor.getString(cursor.getColumnIndex(HomeContract.HomeDb.CONTEUDO)));

            home = new Home(_id, título, conteudo);
        }
        return home;
    }
}
