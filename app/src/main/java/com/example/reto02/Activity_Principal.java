package com.example.reto02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button btnEstadistica = findViewById(R.id.btnEstadistica);
        Button btnCategoria = findViewById(R.id.btnCategoria);
        Button btnConsejo = findViewById(R.id.btnConsejo);
        Button btnAtras = findViewById(R.id.btnAtras);
        Intent intent1 = new Intent(this, Activity_Estadisticas.class);
        Intent intent2 = new Intent(this, Activity_Categorias.class);
        Intent intent3 = new Intent(this, Activity_Consejos.class);
        Intent intent4 = new Intent(this, Activity_Login.class);
        //Boton Estadistica
        btnEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
        //Boton Categoria
        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
        //Boton Consejo
        btnConsejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

        //Boton Retroceso
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(intent4);}
        });
    }
}