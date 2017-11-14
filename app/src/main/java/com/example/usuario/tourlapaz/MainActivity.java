package com.example.usuario.tourlapaz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterDatos.onLugarSelectedListener{


    RecyclerView lugaresRecyclerView;
    AdapterDatos lugarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lugaresRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        lugaresRecyclerView.setHasFixedSize(true);
        lugaresRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        lugarAdapter = new AdapterDatos(this, this);

        llenarDatos();

        lugaresRecyclerView.setAdapter(lugarAdapter);

    }



    private void llenarDatos() {
        List<Lugares> lista = new ArrayList<>();

        lista.add(new Lugares( getString(R.string.NomBrujas), getString(R.string.Descripcion_brujas), R.drawable.brujaslogo));
        lista.add(new Lugares( getString(R.string.NomJaen), getString(R.string.Descripcion_jaen), R.drawable.jaenlogo));
        lista.add(new Lugares( getString(R.string.NomMuela), getString(R.string.Descripcion_muela), R.drawable.muelalogo));
        lista.add(new Lugares( getString(R.string.NomSanfra), getString(R.string.Descripcion_sanfra), R.drawable.sanfralogo));
        lista.add(new Lugares( getString(R.string.NomHampaturi), getString(R.string.Descripcion_pampa), R.drawable.pampalaramalogo));
        lista.add(new Lugares( getString(R.string.NomLuna), getString(R.string.Descripcion_luna), R.drawable.lunalogo));
        lista.add(new Lugares( getString(R.string.NomAnimas), getString(R.string.Descripcion_animas), R.drawable.animaslogo));
        lista.add(new Lugares( getString(R.string.NomCoroico), getString(R.string.DescripcionCoroico), R.drawable.coroicologo));
        lista.add(new Lugares( getString(R.string.NomCopacabana), getString(R.string.DescripcionCopacabana), R.drawable.copacapanalogo));
        lista.add(new Lugares( getString(R.string.NomMallasa), getString(R.string.DescripcionMallasa), R.drawable.mallasalogo));

        lugarAdapter.setDataset(lista);

    }
    @Override
    public void onLugarSelected(Lugares lu) {
        Intent intent =new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("lugares", lu);
        startActivity(intent);

    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch (id){
            case R.id.pag_web:
                Intent intent1=new Intent(MainActivity.this, WebsitesActivity.class);
                startActivity(intent1);
                return true;
            case R.id.acerca_de:
                Intent intent=new Intent(MainActivity.this, AcercaActivity.class);
                startActivity(intent);
                return true;
            case R.id.cerrarSesion:
                SharedPreferences misPreferencias=getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=misPreferencias.edit();
                boolean valor=false;
                editor.putBoolean("sesion", valor);
                editor.commit();
                finish();
                return true;
            case R.id.salir:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
