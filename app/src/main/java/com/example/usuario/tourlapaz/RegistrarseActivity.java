package com.example.usuario.tourlapaz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistrarseActivity extends AppCompatActivity {


    private Animation animacion;
    private ImageView img;

    private EditText NomUsuario;
    private EditText Usuario;
    private EditText Contraseña;
    private EditText ContraseñaDos;
    private Button Registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splashscreen);
        img = (ImageView) findViewById(R.id.logotour);
        img.startAnimation(animacion);


        NomUsuario=(EditText) findViewById(R.id.NombreCompleto);
        Usuario=(EditText) findViewById(R.id.IngreseUsuario);
        Contraseña=(EditText) findViewById(R.id.Contraseña);
        ContraseñaDos=(EditText) findViewById(R.id.ContraseñaDos);
        Registro =(Button) findViewById(R.id.Registro);

        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarRegistro();
            }
        });


    }

    private void guardarRegistro() {
        if(!NomUsuario.getText().toString().equals("") && !Usuario.getText().toString().equals("") && !Contraseña.getText().toString().equals("") && !ContraseñaDos.getText().toString().equals("")){
            if (Contraseña.getText().toString().equals(ContraseñaDos.getText().toString())){
                SharedPreferences misPreferencias=getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                String Nombre=NomUsuario.getText().toString();
                String User=Usuario.getText().toString();
                String Pass=Contraseña.getText().toString();

                SharedPreferences.Editor editor=misPreferencias.edit();
                editor.putString("NombreUsuario", Nombre );
                editor.putString("Usuario", User);
                editor.putString("Contraseña", Pass);

                editor.commit();

                Intent intent=new Intent(RegistrarseActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Las Contraseñas No Coinciden", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Falta Llenar Datos", Toast.LENGTH_SHORT).show();
        }

    }
}
