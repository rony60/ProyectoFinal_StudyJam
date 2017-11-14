package com.example.usuario.tourlapaz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.usuario.tourlapaz.R.string.NomLuna;

public class DetalleActivity extends AppCompatActivity {

    private Intent intent;

    TextView nombre, descripcion;
    ImageView imagenDetalle;

    FloatingActionButton GoogleMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        getSupportActionBar().setTitle(R.string.TituloDescripcion);

        imagenDetalle = (ImageView) findViewById(R.id.imagen_detalle);
        nombre = (TextView) findViewById(R.id.texto_detalle);
        descripcion = (TextView) findViewById(R.id.descripcion_detalle);

        GoogleMaps=(FloatingActionButton) findViewById(R.id.GoogleMaps);

        Bundle bundle = getIntent().getExtras();
        final Lugares lugar = (Lugares) bundle.getSerializable("lugares");

        imagenDetalle.setImageResource(lugar.getFoto());
        nombre.setText(lugar.getNombre());
        descripcion.setText(lugar.getInfo());


        GoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirGoogleMaps(lugar);
            }
        });

    }

    private boolean abrirGoogleMaps(Lugares nombre) {
        String nom=nombre.getNombre().toString();

        switch (nom){

            case "Calle de las Brujas":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.4962002, -68.139549"));
                startActivity(intent);
                return true;
            case "Iglesia de San Francisco":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.4969137, -68.1367886"));
                startActivity(intent);
                return true;
            case "Cascadas de Hampaturi":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5591683, -68.1028507"));
                startActivity(intent);
                return true;
            case "Valle de La Luna":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5673591, -68.0950024"));
                startActivity(intent);
                return true;
            case "Calle Jaen":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.492213, -68.1360472"));
                startActivity(intent);
                return true;
            case "La Muela del Diablo":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5622658, -68.0574811"));
                startActivity(intent);
                return true;
            case "Valle de las Animas":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5480289, -68.0116696"));
                startActivity(intent);
                return true;
            case "Coroico":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.195264, -67.7308416"));
                startActivity(intent);
                return true;
            case "Mallasa":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.5728784, -68.083698"));
                startActivity(intent);
                return true;
            case "Copacabana":
                intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo: -16.1792276, -69.1093047"));
                startActivity(intent);
                return true;
            default:
                return true;
        }




    }


    //codigo del menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_detalle, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch (id){
            case R.id.GaleriaImagenes:

                Bundle bundle = getIntent().getExtras();
                Lugares lugar = (Lugares) bundle.getSerializable("lugares");
                String nom = lugar.getNombre().toString();

                intent =new Intent(getApplicationContext(), GaleriaActivity.class);
                intent.putExtra("nombre", nom);
                startActivity(intent);
                return true;
            case R.id.acerca_de:
                intent=new Intent(DetalleActivity.this, AcercaActivity.class);
                startActivity(intent);
                return true;
            case R.id.ComoLlegar:
                bundle = getIntent().getExtras();
                lugar = (Lugares) bundle.getSerializable("lugares");
                nom = lugar.getNombre().toString();

                intent =new Intent(getApplicationContext(), LlegarActivity.class);
                intent.putExtra("nombre", nom);
                startActivity(intent);

                return true;
            case R.id.salir:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
