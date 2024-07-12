package com.example.blogapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    AppCompatButton b1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SharedPreferences pref= getSharedPreferences("logg",MODE_PRIVATE);
        String username = pref.getString("user",null);
        if(username != null){
            Intent i = new Intent(getApplicationContext(), Menu.class);
            startActivity(i);
        }

        b1 = (AppCompatButton) findViewById(R.id.login);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.pass);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String username = ed1.getText().toString();
                    String password = ed2.getText().toString();

                    if (username.equals("admin") && password.equals("123")){

                        SharedPreferences pref= getSharedPreferences("logg",MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                        editor.putString("user","admin");
                        editor.apply();

                        Intent i = new Intent(getApplicationContext(), Menu.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"entered information is wrong",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}