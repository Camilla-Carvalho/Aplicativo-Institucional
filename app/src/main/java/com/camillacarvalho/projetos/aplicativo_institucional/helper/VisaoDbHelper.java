package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.camillacarvalho.projetos.aplicativo_institucional.model.Missao;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Visao;

public class VisaoDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Visao.db";
    public static final int DATABASE_VERSION = 1;

    public final String CREATE = "create table " + VisaoContract.VisaoDb.TABLE_NAME +"( "
            + VisaoContract.VisaoDb._ID + " integer primary key autoincrement, "
            + VisaoContract.VisaoDb.TITULO + " text, "
            + VisaoContract.VisaoDb.CONTEUDO + " text)";

    private final String DELETE = "drop table if exists " + VisaoContract.VisaoDb.TABLE_NAME;

    public VisaoDbHelper(@Nullable Context context) {
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

    public void inserirVisao(){
        // inserir dados da visao
        try {
            SQLiteDatabase sqLiteDatabaseWritable = this.getWritableDatabase();
            ContentValues cvs = new ContentValues();
            cvs.put(VisaoContract.VisaoDb.TITULO, "## NOSSA VISÃO ##");
            cvs.put(VisaoContract.VisaoDb.CONTEUDO, "Nossa visão é oferecer o que há de melhor em Tecnologia da Informação aos nossos clientes!");
            sqLiteDatabaseWritable.insert(VisaoContract.VisaoDb.TABLE_NAME, null, cvs);
        }catch(Exception e){}
    }

    @SuppressLint("Range")
    public Visao consultarVisao() {
        Visao visao = null;
        try{
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from "
                    + VisaoContract.VisaoDb.TABLE_NAME, null);
            while(cursor.moveToNext()){
                long _id = (cursor.getLong(cursor.getColumnIndex(VisaoContract.VisaoDb._ID)));
                String título = (cursor.getString(cursor.getColumnIndex(VisaoContract.VisaoDb.TITULO)));
                String conteudo = (cursor.getString(cursor.getColumnIndex(VisaoContract.VisaoDb.CONTEUDO)));
                visao = new Visao(_id, título, conteudo);
              }
        }catch(Exception e){ /**/ }
        finally {
            if( visao == null)
                visao = new Visao(1, "## NOSSA VISÃO ##","Nossa visão é oferecer o que há de melhor em Tecnologia da Informação aos nossos clientes!");
        }
        return visao;
    }
}
