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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private Animation animacion;
    private ImageView img;

    private Button btn;
    private Button btnRegistro;
    private EditText usuario, pass;

    public CheckBox getSesion() {
        return sesion;
    }
    private CheckBox sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registro);

        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splashscreen);
        img = (ImageView) findViewById(R.id.logotour);
        img.startAnimation(animacion);


        btn=(Button) findViewById(R.id.button);
        sesion=(CheckBox) findViewById(R.id.sesion);
        btnRegistro=(Button) findViewById(R.id.buttonRegistrar);
        usuario=(EditText) findViewById(R.id.Usuario);
        pass=(EditText) findViewById(R.id.Pass);


        SharedPreferences misPreferencias=getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        sesion.setChecked(misPreferencias.getBoolean("sesion", false));
        valida();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IniciarSesion();


            }

        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(RegistroActivity.this, RegistrarseActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void IniciarSesion() {
        SharedPreferences misPreferencias=getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String UsuarioValida=misPreferencias.getString("Usuario", "");
        String PassValida=misPreferencias.getString("Contraseña", "");
        if(usuario.getText().toString().equals(UsuarioValida) && pass.getText().toString().equals(PassValida)) {
            guardar();
            Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Usuario o Contraseña Incorecta", Toast.LENGTH_SHORT).show();
        }

    }

    private void guardar() {
        SharedPreferences misPreferencias=getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=misPreferencias.edit();
        boolean valor=sesion.isChecked();
        editor.putBoolean("sesion", valor);
        editor.commit();

    }

    private void valida() {
        SharedPreferences misPreferencias=getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        Boolean valor=sesion.isChecked();
        if(valor==true){
            Intent intent=new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
