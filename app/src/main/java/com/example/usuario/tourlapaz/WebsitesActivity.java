package com.example.usuario.tourlapaz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class WebsitesActivity extends AppCompatActivity {

    private LinearLayout ibAbrePaginaWeb1;
    private LinearLayout ibAbrePaginaWeb2;
    private LinearLayout ibAbrePaginaWeb3;
    private LinearLayout ibAbrePaginaWeb4;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        ibAbrePaginaWeb1=(LinearLayout) findViewById(R.id.PaginaWeb1);
        ibAbrePaginaWeb2=(LinearLayout) findViewById(R.id.PaginaWeb2);
        ibAbrePaginaWeb3=(LinearLayout) findViewById(R.id.PaginaWeb3);
        ibAbrePaginaWeb4=(LinearLayout) findViewById(R.id.PaginaWeb4);


        ibAbrePaginaWeb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginWeb1();
            }
        });
        ibAbrePaginaWeb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginWeb2();
            }
        });
        ibAbrePaginaWeb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginWeb3();
            }
        });
        ibAbrePaginaWeb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginWeb4();
            }
        });
    }

    private void abrirPaginWeb1() {
        intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.turismolapaz.com"));
        startActivity(intent);
    }

    private void abrirPaginWeb2() {
        intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.boliviaturismo.com"));
        startActivity(intent);
    }
    private void abrirPaginWeb3() {
        intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.turismocatacora.com"));
        startActivity(intent);
    }
    private void abrirPaginWeb4() {
        intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.boliviaentusmanos.com"));
        startActivity(intent);
    }
}
