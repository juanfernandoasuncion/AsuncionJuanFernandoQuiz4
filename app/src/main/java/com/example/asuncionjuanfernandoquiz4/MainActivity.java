package com.example.asuncionjuanfernandoquiz4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtPassword, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.etName);
        txtPassword = findViewById(R.id.etPassword);
        txtEmail = findViewById(R.id.etEmail);
    }

    public void goLogin(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void userRegister(View v) {
        FileOutputStream fos = null;
        File file = new File(getExternalFilesDir(null), "user4.txt");
        try {
            fos = new FileOutputStream(file);
            fos.write((txtName.getText().toString() + ", ").getBytes());
            fos.write((txtPassword.getText().toString() + "- ").getBytes());
            fos.write(txtEmail.getText().toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "SAVED DATA IN EXTERNAL", Toast.LENGTH_LONG).show();
    }
}
