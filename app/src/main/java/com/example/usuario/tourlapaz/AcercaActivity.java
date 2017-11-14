package com.example.usuario.tourlapaz;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AcercaActivity extends AppCompatActivity {
    private Button ibEnviarEmail, ibLlamada;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        getSupportActionBar().setTitle("About");

        ibEnviarEmail=(Button) findViewById(R.id.correo);
        ibLlamada=(Button) findViewById(R.id.Llamada);

        ibEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });

        ibLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamar();
            }
        });
    }

    private void llamar() {
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:60533673"));
        startActivity(intent);
    }


    public void enviarEmail(){
        String [] TO = {"gutierrezrony60@gmail.com"};
        //String [] CC = {"androidlapaz@gmail.com"};
        String asunto = "Correo Importante";
        String contenido = "Escriba su comentario aqui...";

        intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, TO);
       // intent.putExtra(Intent.EXTRA_CC, CC);
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        intent.putExtra(Intent.EXTRA_TEXT, contenido);

        startActivity(Intent.createChooser(intent, "Envia Correo"));

    }
}
