package com.example.reto02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Crear archivo para usuarios y escribir los datos
        File file1 = new File(getFilesDir(), "datos.txt");
        if (!file1.exists()){
            try {
                FileWriter writer = new FileWriter(file1);
                writer.append("root,root@root.com,toor,TOOR\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Crear archivo para registro de plastico
        File file2 = new File(getFilesDir(), "plastico.txt");
        if (!file2.exists()) {
            try {
                FileWriter writer = new FileWriter(file2);
                writer.append("15,150000,enero\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Crear archivo para registro de papel
        File file3 = new File(getFilesDir(), "papel.txt");
        if (!file3.exists()) {
            try {
                FileWriter writer = new FileWriter(file3);
                writer.append("15,150000,enero\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Crear archivo para registro de consejos
        File file4 = new File(getFilesDir(), "consejos.txt");
        try {
            FileWriter writer = new FileWriter(file4);

            // Lista de consejos para ahorrar agua y electricidad en un array
            String[] consejos = {
                    "INSTALA RECIPIENTES DONDE PUEDAS DIVIDIR LA BASURA: ORGÁNICA, VIDRIO, CARTÓN, PLASTICOS Y RESIDUOS TÓXICOS",
                    "COMPRA PRODUCTOS CUYOS ENVASES SEAN RESPETUOSOS CON EL MEDIO AMBIENTE",
                    "REUTILIZA PAPEL EN IMPRESORAS Y FOTOCOPIADORAS",
                    "COMPRA BOLSAS DE VARIOS USOS",
                    "NO UTILICES BOLSAS PLASTICAS DE UN SOLO USO",
            };
            // Recorrer el array y agregar los consejos al archivo
            writer.append("Lista de consejos para ahorrar agua y electricidad:\n");
            for (String consejo : consejos) {
                writer.append(consejo).append("\n");
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, Activity_Login.class);
        startActivity(intent);
    }
    }