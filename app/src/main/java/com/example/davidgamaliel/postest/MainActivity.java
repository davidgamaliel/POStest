package com.example.davidgamaliel.postest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected EditText username;
    protected EditText password;
    public static final String MY_PREFERENCES = "UserPref";
    public static final String USERNAME = "usernameKey";
    public static final String PASSWORD = "passwordKey";
    SharedPreferences sPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username_field);
        password = (EditText) findViewById(R.id.password_field);
        Button register = (Button) findViewById(R.id.register);
        sPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();

                SharedPreferences.Editor editor = sPreferences.edit();
                editor.putString(USERNAME, inputUsername);
                editor.putString(PASSWORD, inputPassword);
                editor.commit();

                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
