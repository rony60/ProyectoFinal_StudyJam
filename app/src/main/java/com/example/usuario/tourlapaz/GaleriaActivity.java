package com.example.usuario.tourlapaz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class GaleriaActivity extends AppCompatActivity {
    private ImageView imgDetalle1;
    private ImageView imgDetalle2;
    private ImageView imgDetalle3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        getSupportActionBar().setTitle(R.string.ImagenGaleria);

        imgDetalle1=(ImageView) findViewById(R.id.ImagenDetalle1);
        imgDetalle2=(ImageView) findViewById(R.id.ImagenDetalle2);
        imgDetalle3=(ImageView) findViewById(R.id.ImagenDetalle3);


        Bundle bundle = getIntent().getExtras();
        final String nom = (String) bundle.getSerializable("nombre");

        llenarGaleria(nom);

    }

    private boolean llenarGaleria(String nom) {


        switch (nom) {
            case "Calle de las Brujas":
                imgDetalle1.setImageResource(R.drawable.brujaa);
                imgDetalle2.setImageResource(R.drawable.brujasb);
                imgDetalle3.setImageResource(R.drawable.brujasc);

                return true;
            case "Iglesia de San Francisco":
                imgDetalle1.setImageResource(R.drawable.sanfraa);
                imgDetalle2.setImageResource(R.drawable.sanfrab);
                imgDetalle3.setImageResource(R.drawable.sanfrac);

                return true;
            case "Cascadas de Hampaturi":
                imgDetalle1.setImageResource(R.drawable.pampalaramaa);
                imgDetalle2.setImageResource(R.drawable.pampalaramab);
                imgDetalle3.setImageResource(R.drawable.pampalaramac);

                return true;
            case "Valle de la Luna":
                imgDetalle1.setImageResource(R.drawable.lunab);
                imgDetalle2.setImageResource(R.drawable.lunac);
                imgDetalle3.setImageResource(R.drawable.lunad);

                return true;
            case "Calle Jaen":
                imgDetalle1.setImageResource(R.drawable.jaenaa);
                imgDetalle2.setImageResource(R.drawable.jaenb);
                imgDetalle3.setImageResource(R.drawable.jaenc);

                return true;
            case "La Muela del Diablo":
                imgDetalle1.setImageResource(R.drawable.muelaa);
                imgDetalle2.setImageResource(R.drawable.muelab);
                imgDetalle3.setImageResource(R.drawable.muelac);

                return true;
            case "Valle de las Animas":
                imgDetalle1.setImageResource(R.drawable.animasb);
                imgDetalle2.setImageResource(R.drawable.animasc);
                imgDetalle3.setImageResource(R.drawable.animasd);

                return true;
            case "Coroico":
                imgDetalle1.setImageResource(R.drawable.coroicoa);
                imgDetalle2.setImageResource(R.drawable.coroicob);
                imgDetalle3.setImageResource(R.drawable.coroicoc);
                return true;
            case "Mallasa":
                imgDetalle1.setImageResource(R.drawable.mallasaa);
                imgDetalle2.setImageResource(R.drawable.mallasab);
                imgDetalle3.setImageResource(R.drawable.mallasac);
                return true;
            case "Copacabana":
                imgDetalle1.setImageResource(R.drawable.copacabanaa);
                imgDetalle2.setImageResource(R.drawable.copacabanab);
                imgDetalle3.setImageResource(R.drawable.copacabanac);
                return true;
            default:
                return true;

        }

    }
}
