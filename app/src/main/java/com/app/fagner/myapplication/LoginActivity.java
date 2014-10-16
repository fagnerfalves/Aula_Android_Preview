package com.app.fagner.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity implements View.OnClickListener{
    String mat,nick;
    EditText editmatricula;
    EditText editnick;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylugao);

        editmatricula = (EditText) findViewById(R.id.editTextMatricula);
        editnick = (EditText) findViewById(R.id.editTextNick);
        ok = (Button) findViewById(R.id.button);

        SharedPreferences sharedPreferences = this.getSharedPreferences("aula.eccard.prefs", Context.MODE_PRIVATE);
        mat = sharedPreferences.getString("matricula", "");
        nick = sharedPreferences.getString("nick", "");

        // se a matricula tiver sido iniciada anteriormente setar esta matricula
        if(!mat.equals("")){
            Log.i("entrou", "entrour");
            editmatricula.setText(mat);
        }
        if(!nick.equals("")){
            Log.i("entrou", "entrour");
            editnick.setText(nick);
        }

        ok.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                SharedPreferences sharedPreferences = this.getSharedPreferences("aula.eccard.prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("matricula",editmatricula.getText().toString());
                editor.putString("nick",editnick.getText().toString());
                editor.commit();

                Intent i = new Intent(this, MyActivity.class);
                startActivity(i);

                break;
            default:
                break;
        }
    }
}
