package com.example.practicalogin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    EditText editTextUser, editTextPassword;
    private boolean esperarSegundos = false;
    private int intentos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referenciaWiews();

    }

    private void validarDatos(String mail, String password) {

        if (mail.equals("admin@correo.com") && password.equals("1234")) {
            Toast.makeText(this, getString(R.string.editTextAcceso), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        } else {
            intentos++;

            if (intentos < 3) {
                Toast.makeText(this, getString(R.string.editTextAcceso2) + " " + intentos , Toast.LENGTH_SHORT).show();
            } else {

                if (esperarSegundos) {
                    Toast.makeText(this, getString(R.string.editTextAcceso3), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(this, getString(R.string.editTextAcceso4), Toast.LENGTH_SHORT).show();
                esperarSegundos = true;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        esperarSegundos = false;
                        intentos = 0;
                    }
                }, 10000);
            }
        }
    }

    private void referenciaWiews() {
        btnIngresar = findViewById(R.id.btnIngresar);
        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos(editTextUser.getText().toString(), editTextPassword.getText().toString());
            }
        });

    }

}
