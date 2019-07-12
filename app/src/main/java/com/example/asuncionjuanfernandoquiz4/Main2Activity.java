package com.example.asuncionjuanfernandoquiz4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    TextView txtName, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtName = findViewById(R.id.tvName);
        txtPassword = findViewById(R.id.tvPassword);
    }

    public void goRegister(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void userLogin(View v) {
        Intent i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }

    public void displayExternal(View v) {
        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int letter = 0;
        try {
            File file = new File(getExternalFilesDir(null), "user4.txt");
            fis = new FileInputStream(file);
            while((letter = fis.read()) != -1) {
                buffer.append((char)letter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        txtName.setText(buffer.substring(0, buffer.indexOf(",")));
        txtPassword.setText(buffer.substring(buffer.indexOf(",") +1 +1, buffer.indexOf("-")));
    }
}
