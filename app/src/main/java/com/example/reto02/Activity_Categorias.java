package com.example.reto02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        Button botonRegresar = findViewById(R.id.botonRetroceso3);
        Button btnPapel = findViewById(R.id.buttonPapel);
        Button btnPlastico = findViewById(R.id.buttonPlastico);
        Intent intent1 = new Intent(this, Activity_Principal.class);
        Intent intent2 = new Intent(this, Activity_registro_plastico.class);
        Intent intent3 = new Intent(this, Activity_registro_papel.class);

        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });

        //Boton Registro de plástico
        btnPlastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        //Boton Registro de papel
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

    }
}