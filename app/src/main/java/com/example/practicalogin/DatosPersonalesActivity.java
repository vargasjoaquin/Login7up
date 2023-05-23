package com.example.practicalogin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DatosPersonalesActivity extends AppCompatActivity {

    private Button btnLlamada;
    private Button btnEmail;

    private Button btnGitHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datospersonales);

        btnLlamada = findViewById(R.id.call_button);
        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroTelefono = "123456789";
                dialHacerLlamada(numeroTelefono);
            }
        });

        btnEmail = findViewById(R.id.btnEnviarEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarEmail();
            }
        });

        btnGitHub = findViewById(R.id.btnGitHub);
        btnGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirGitHub();
            }
        });
    }

    private void dialHacerLlamada(String numeroTelefono){
        Uri uri = Uri.parse("tel:" + numeroTelefono);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);

        if(intent.resolveActivity(getPackageManager()) !=  null){
            startActivity(intent);
        }
    }


    public void enviarEmail() {
        String[] recipient = {"tatinoteicito@gmail.com"};

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + Uri.encode(recipient[0])));
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(Intent.createChooser(intent, "Enviar correo en: "));
    }

    private void abrirGitHub(){
        String url = "https://github.com/vargasjoaquin";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
