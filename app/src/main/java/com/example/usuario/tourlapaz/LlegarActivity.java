package com.example.usuario.tourlapaz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LlegarActivity extends AppCompatActivity {

    private TextView infoMini;
    private LinearLayout taxi, taxi2, taxi3, mini;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llegar);

        getSupportActionBar().setTitle(R.string.Mini);

        infoMini=(TextView) findViewById(R.id.InfoMini);
        taxi=(LinearLayout) findViewById(R.id.LlamarTaxi1);
        taxi2=(LinearLayout) findViewById(R.id.LlamarTaxi2);
        taxi3=(LinearLayout) findViewById(R.id.LlamarTaxi3);
        mini=(LinearLayout) findViewById(R.id.Mini);


        Bundle bundle = getIntent().getExtras();
        final String nom = (String) bundle.getSerializable("nombre");

        llenarInfoMini(nom);

        taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:2815151"));
                startActivity(intent);
            }
        });
        taxi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:2221212"));
                startActivity(intent);
            }
        });
        taxi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:2785555"));
                startActivity(intent);
            }
        });

        mini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreUbi(nom);
            }
        });


    }

    private boolean abreUbi(String nom) {
        switch (nom){

            case "Calle de las Brujas":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5046601, -68.1655035"));
                startActivity(intent);
                return true;
            case "Iglesia de San Francisco":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5046601, -68.1655035"));
                startActivity(intent);
                return true;
            case "Cascadas de Hampaturi":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.4880677, -68.2007173"));
                startActivity(intent);
                return true;
            case "Valle de La Luna":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5046601, -68.1655035"));
                startActivity(intent);
                return true;
            case "Calle Jaen":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5046601, -68.1655035"));
                startActivity(intent);
                return true;
            case "La Muela del Diablo":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.4953514, -68.1391493"));
                startActivity(intent);
                return true;
            case "Valle de las Animas":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5030024, -68.1338399"));
                startActivity(intent);
                return true;
            case "Coroico":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.4689398, -68.1164383"));
                startActivity(intent);
                return true;
            case "Mallasa":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.4972834, -68.1367672"));
                startActivity(intent);
                return true;
            case "Copacabana":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.4970216, -68.1539935"));
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }




    private boolean llenarInfoMini(String nom) {
        switch (nom) {
            case "Calle de las Brujas":
                infoMini.setText(R.string.UbiBruja);

                return true;
            case "Iglesia de San Francisco":
                infoMini.setText(R.string.UbiSanfra);

                return true;
            case "Cascadas de Hampaturi":
                infoMini.setText(R.string.UbiHampa);

                return true;
            case "Valle de La Luna":
                infoMini.setText(R.string.UbiLuna);

                return true;
            case "Calle Jaen":
                infoMini.setText(R.string.UbiJaen);

                return true;
            case "La Muela del Diablo":
                infoMini.setText(R.string.UbiMuela);

                return true;
            case "Valle de las Animas":
                infoMini.setText(R.string.UbiAnimas);

                return true;
            case "Coroico":
                infoMini.setText(R.string.UbiCoroico);
                return true;
            case "Mallasa":
                infoMini.setText(R.string.UbiMallasa);
                return true;
            case "Copacabana":
                infoMini.setText(R.string.UbiCopacabana);
                return true;
            default:
                return true;

        }
    }


}
