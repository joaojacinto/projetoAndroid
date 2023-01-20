package com.example.gymapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.gymapp.Classes.SharedPrefManager;
import com.example.gymapp.Classes.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import com.example.gymapp.ui.main.SectionsPagerAdapter;
import com.example.gymapp.databinding.ActivityHomeMainBinding;

public class Home_Main extends AppCompatActivity {

    private ActivityHomeMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);



        //botao com envelope
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView id_avaliacao = (TextView)findViewById(R.id.txtIdAvaliacao);
        TextView id_utilizador = (TextView)findViewById(R.id.txtUtilizador);
        TextView gordura_corporal = (TextView)findViewById(R.id.txtGorduraCorporal);
        TextView massa_muscular = (TextView)findViewById(R.id.txtMassaMuscular);
        TextView peso = (TextView)findViewById(R.id.txtPeso);
        TextView altura = (TextView)findViewById(R.id.txtAltura);
        TextView massa_gorda = (TextView)findViewById(R.id.txtMassaGorda);



        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Login.class));
        }

        User user = SharedPrefManager.getInstance(this).getUser();

        TextView username = (TextView)findViewById(R.id.idUser);
        username.setText(user.getUsername());

        findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });
    }
}