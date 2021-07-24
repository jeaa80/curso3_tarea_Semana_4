package com.jesus.curso3_semana4_petagram_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jesus.curso3_semana4_petagram_final.adapter.ViewPagerAdapter;
import com.jesus.curso3_semana4_petagram_final.fragments.Fragmento_Principal;

public class MainActivity extends AppCompatActivity {
    ViewPagerAdapter mAdapter;
    ViewPager2 viewPager2;
    ImageButton b_siguiente;
    ImageButton b_boton_like;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar topAppBar = (Toolbar) findViewById(R.id.topAppBar);
        setSupportActionBar(topAppBar);


        //Evento para pasar a la otra actividad
        b_siguiente = (ImageButton) findViewById(R.id.b_siguiente);

        b_siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.jesus.curso3_semana4_petagram_final.Favoritos.class);
                startActivity(intent);
                finish();
            }
        });

        viewPager2 = findViewById(R.id.viewPager2);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        // Add Fragments
        viewPager2.setAdapter(mAdapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        int [] icon = new int[]{
            R.drawable.ic_home7,
            R.drawable.ic_perfil7,
        };
        new TabLayoutMediator(tabLayout, viewPager2,((tab, position) -> tab.setIcon(icon[position]))).attach();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contactenos:
                Toast.makeText(this,"Boton Contactenos", Toast.LENGTH_SHORT).show();
                Intent intent_contactenos = new Intent(MainActivity.this, com.jesus.curso3_semana4_petagram_final.Contactenos.class);
                startActivity(intent_contactenos);
                return true;

            case R.id.acercaDe:
                Toast.makeText(this,"Boton Acerca de...", Toast.LENGTH_SHORT).show();
                Intent intent_acercaDe = new Intent(MainActivity.this, com.jesus.curso3_semana4_petagram_final.AcercaDe.class);
                startActivity(intent_acercaDe);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

}