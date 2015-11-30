package com.example.davidgamaliel.postest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by David Gamaliel on 11/21/2015.
 */
public class HomeActivity extends AppCompatActivity {
    private TextView username, password;
    public static final String MY_PREFERENCES = "UserPref";
    public static final String USERNAME = "usernameKey";
    public static final String PASSWORD = "passwordKey";
    SharedPreferences sPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_home);

        username = (TextView) findViewById(R.id.username_view);
        password = (TextView) findViewById(R.id.password_view);
        sPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);

        String name = sPreferences.getString(USERNAME, "username tidak tersimpan");
        String pass = sPreferences.getString(PASSWORD, "password tidak tersimpan");

        username.setText(name);
        password.setText(pass);
    }

    public void logout()
    {
        SharedPreferences sPreferences = getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.clear();
        editor.commit();
        Intent i = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void createShift ()
    {
        Intent i = new Intent(HomeActivity.this, KasirActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
            Toast.makeText(getApplicationContext(), "keteken nih", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.action_signOut) {
            logout();
        }
        if (id == R.id.action_create_shift) {
            createShift();
        }

        return super.onOptionsItemSelected(item);
    }
}
