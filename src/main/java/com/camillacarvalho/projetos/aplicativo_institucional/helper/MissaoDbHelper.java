package com.camillacarvalho.projetos.aplicativo_institucional.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.camillacarvalho.projetos.aplicativo_institucional.model.Home;
import com.camillacarvalho.projetos.aplicativo_institucional.model.Missao;

public class MissaoDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Missao.db";
    public static final int DATABASE_VERSION = 1;

    public final String CREATE = "create table " + MissaoContract.MissaoDb.TABLE_NAME +" ( "
            + MissaoContract.MissaoDb._ID + " integer primary key autoincrement, "
            + MissaoContract.MissaoDb.TITULO + " text, "
            + MissaoContract.MissaoDb.CONTEUDO + " text)";

    private final String DELETE = "drop table if exists " + MissaoContract.MissaoDb.TABLE_NAME;

    public MissaoDbHelper(@Nullable Context context) {
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

    public void inserirMissao(){
        // inserir dados da missao
        try {
            SQLiteDatabase sqLiteDatabaseWritable = this.getWritableDatabase();
            ContentValues cvs = new ContentValues();
            cvs.put(MissaoContract.MissaoDb.TITULO, "## NOSSA MISSÃO ##");
            cvs.put(MissaoContract.MissaoDb.CONTEUDO, "Nossa missão é planejar, desenvolver e entregar softwares com garantia de alta disponibilidade e qualidade aos nossos clientes!");
            sqLiteDatabaseWritable.insert(MissaoContract.MissaoDb.TABLE_NAME, null, cvs);
        }catch(Exception e){}
    }

    @SuppressLint("Range")
    public Missao consultarMissao(){
        Missao missao = null;
        try {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from "
                    + MissaoContract.MissaoDb.TABLE_NAME, null);
            while(cursor.moveToNext()){
                long _id = (cursor.getLong(cursor.getColumnIndex(MissaoContract.MissaoDb._ID)));
                String título = (cursor.getString(cursor.getColumnIndex(MissaoContract.MissaoDb.TITULO)));
                String conteudo = (cursor.getString(cursor.getColumnIndex(MissaoContract.MissaoDb.CONTEUDO)));

                missao = new Missao(_id, título, conteudo);
            }
        }catch(Exception e){ /**/ }
        finally {
            if( missao == null)
                missao = new Missao(1, "## NOSSA MISSÃO ##", "Nossa missão é planejar, desenvolver e entregar softwares com garantia de alta disponibilidade e qualidade aos nossos clientes!");
        }
        return missao;
    }
}
