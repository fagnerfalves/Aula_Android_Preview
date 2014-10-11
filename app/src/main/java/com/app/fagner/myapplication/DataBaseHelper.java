package com.app.fagner.myapplication;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by fagner on 11/10/14.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH="/data/data/com.example.myapplication/";
    private static String DB_NAME = "banco.db";
    public SQLiteDatabase dbQuery;
    private final Context dbContexto;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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

}
