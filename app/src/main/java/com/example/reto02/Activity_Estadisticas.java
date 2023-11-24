package com.example.reto02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.reto02.modelo.Plastico;
import com.example.reto02.modelo.Papel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Activity_Estadisticas extends AppCompatActivity {
    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        //Elementos de la interfaz
        Button botonRegresar = findViewById(R.id.botonRetroceso2);
        tableLayout = findViewById(R.id.myTableLayout);
        Intent intent = new Intent(this, Activity_Principal.class);

        //Carga de los archivos de plastico y papel
        File plasticoFile = new File(getFilesDir(), "plastico.txt");
        File papelFile = new File(getFilesDir(), "papel.txt");

        //Listas de Plastico y Papel
        List<Plastico> listaPlastico = leerArchivoPlastico(plasticoFile);
        List<Papel>listaPapel = leerArchivoPapel(papelFile);

        //Crear la Tabla
        addElementPLastico(listaPlastico);
        addElementPapel(listaPapel);
        addPromedioPlastico(listaPlastico);
        addPromedioPapel(listaPapel);

        //Boton Regresar
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    private void addPromedioPlastico(List<Plastico> plasticoList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioConsumoPlastico = calcularPromedioVolumenPlastico(plasticoList);
        float promedioPrecioPlastico = calcularPromedioPrecioPLastico(plasticoList);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("Plastico");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioConsumoPlastico));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioPrecioPlastico));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }

    private void addPromedioPapel(List<Papel> papelList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioConsumoPapel = calcularPromedioHojas(papelList);
        float promedioPrecioPapel = calcularPromedioPrecioPapel(papelList);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("Papel");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioConsumoPapel));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioPrecioPapel));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }

    private void addElementPLastico(List<Plastico> plasticoList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Plastico item: plasticoList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText("Plastico");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getVolumen())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }

    private void addElementPapel(List<Papel> papelList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Papel item: papelList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText("Papel");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getHojas())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }
    private static List<Plastico> leerArchivoPlastico(File archivo) {
        List<Plastico> listaPlastico = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float volumen = Float.parseFloat(datos[0]);
                float precio = Float.parseFloat(datos[1]);
                String mes = datos[2];

                Plastico plastico = new Plastico(volumen, precio, mes);
                listaPlastico.add(plastico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaPlastico;
    }

    private static List<Papel> leerArchivoPapel(File archivo) {
        List<Papel> listaPapel = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float hojas = Float.parseFloat(datos[0]);
                float precio = Float.parseFloat(datos[1]);
                String mes = datos[2];

                Papel papel = new Papel(hojas, precio, mes);
                listaPapel.add(papel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaPapel;
    }

    private float calcularPromedioVolumenPlastico(List<Plastico> plasticoList) {
        float sum = 0;
        for (Plastico item : plasticoList) {
            sum += item.getVolumen();
        }
        return sum / plasticoList.size();
    }
    private float calcularPromedioPrecioPLastico(List<Plastico> plasticoList) {
        float sum = 0;
        for (Plastico item : plasticoList) {
            sum += item.getPrecio();
        }
        return sum / plasticoList.size();
    }

    private float calcularPromedioHojas(List<Papel> papelList) {
        float sum = 0;
        for (Papel item : papelList) {
            sum += item.getHojas();
        }
        return sum / papelList.size();
    }

    private float calcularPromedioPrecioPapel(List<Papel> papelList) {
        float sum = 0;
        for (Papel item : papelList) {
            sum += item.getPrecio();
        }
        return sum / papelList.size();
    }
}