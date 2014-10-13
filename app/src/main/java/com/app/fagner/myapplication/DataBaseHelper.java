package com.app.fagner.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app.fagner.myapplication.modelo.Noticia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by fagner on 11/10/14.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH="/data/data/com.app.fagner.myapplication/";
    private static String DB_NAME = "banco.db";
    public SQLiteDatabase dbQuery;
    private final Context dbContexto;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        dbContexto=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CriarDataBase() throws IOException
    {

        boolean dbExist = checkDataBase();

        if (!dbExist)
        {
            this.getReadableDatabase();

            try
            {
                this.copiarDataBase();
            }
            catch (IOException e)
            {
                throw new Error("Erro ao copiar o Banco de Dados!");
            }
        }
    }

    private void copiarDataBase() throws IOException
    {

        InputStream myInput = dbContexto.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0)
        {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private boolean checkDataBase()
    {

        SQLiteDatabase checkDB = null;

        try
        {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }
        catch (SQLiteException e)
        {}

        if (checkDB != null)
        {
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    public void abrirDataBase() throws SQLException
    {
        String myPath = DB_PATH + DB_NAME;
        dbQuery = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);


    }

    public void criatNoticia(Noticia noticia){
        Log.i("entrando no criarção da noticia", "entrando criação noticiaaaaaaaaaaaaaaaa");
        this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("_id",noticia.getCodigo());
        values.put("titulo",noticia.getTitulo());
        values.put("data",noticia.getData());
        values.put("hora",noticia.getHora());
        values.put("conteudo",noticia.getConteudo());
        values.put("visualizar",noticia.getVisualizar());
        try{
            dbQuery.insert("Noticia",null,values);
        }catch (SQLException e){
            Log.i(e.toString(),e.toString());
        }
    }


    public void setVisualizarNoticia1(int codigo){
        dbQuery.execSQL("UPDATE Noticia SET visualizar = '1' where _id =" + String.valueOf(codigo));
    }

    public int getVisualizarNoticia(int codigo){
        String[] whereArgs = new String[] { String.valueOf(codigo)};
        Cursor cursor = dbQuery.rawQuery("SELECT visualizar FROM Noticia where _id = ?",whereArgs);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public ArrayList<Noticia> getNoticias() {

        ArrayList<Noticia> noticias = new ArrayList<Noticia>();

        Cursor cursor = dbQuery.rawQuery("select * from Noticia", null);
        // codigo,assunto,dataExpedida,horaExpedida,cursoRelacionado,descricao
        if (cursor.moveToFirst()) {
            do {
                noticias.add(new Noticia(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3),cursor.getString(4)));
            } while (cursor.moveToNext());
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return noticias;
    }
    public int getCodigoUltimaNoticia(){
        Cursor cursor = dbQuery.rawQuery("SELECT MAX(_id) FROM Noticia",null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }
}
