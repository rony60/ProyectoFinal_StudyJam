package com.example.usuario.tourlapaz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class InicioActivity extends Activity{


    private MediaPlayer mp;
    private Animation animacion;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();//Hace desaparecer el titulo en la animacion
        setContentView(R.layout.activity_inicio);

        //cod audio de inicio
        mp= MediaPlayer.create(this, R.raw.hola);
        mp.start();


        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splashscreen);

        img = (ImageView) findViewById(R.id.logotour);

        img.startAnimation(animacion);

        animacion.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(i);

                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


}
