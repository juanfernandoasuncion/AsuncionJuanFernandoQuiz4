package com.example.asuncionjuanfernandoquiz4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main3Activity extends AppCompatActivity {

    TextView txtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txtEmail = findViewById(R.id.tvEmail);
    }

    public void goLogout(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void displayInfo(View v) {
        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int letter = 0;
        try {
            File file = new File(getExternalFilesDir(null), "user4.txt");
            fis = new FileInputStream(file);
            while ((letter = fis.read()) != -1) {
                buffer.append((char) letter);
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
        txtEmail.setText(buffer.substring(buffer.indexOf("-") +1 +1));
    }
}