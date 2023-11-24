package com.example.reto02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import com.example.reto02.modelo.Plastico;
public class Activity_registro_plastico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_plastico);
        // Obtener referencias a los elementos de la interfaz de usuario
        Button botonRegresar = findViewById(R.id.botonRegresar5);
        Button botonRegistrar = findViewById(R.id.btnRegistrarPlastico);

        EditText volumen = findViewById(R.id.editTextVolumen);
        EditText precio = findViewById(R.id.editTextPrecioA);
        EditText mes = findViewById(R.id.editTextMesA);

        // Intent utilizado para regresar a la actividad Categorias
        Intent intent1 = new Intent(this, Activity_Categorias.class);

        // Intent utilizado para navegar a la actividad Principal
        Intent intent2 = new Intent(this, Activity_Principal.class);

        // Configuración del botón "Regresar"
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });

        // Configuración del botón "Registrar"
        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar que los campos no estén vacíos
                if (!volumen.getText().toString().isEmpty() && !precio.getText().toString().isEmpty() && !mes.getText().toString().isEmpty()) {
                    String mesBuscado = mes.getText().toString();
                    boolean mesExiste = verificarMes(mesBuscado);
                    if (mesExiste) {
                        // El mes ya existe en el archivo
                        Toast.makeText(Activity_registro_plastico.this, "El mes ya existe", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean datosGuardados = guardarDatos(volumen.getText().toString(), precio.getText().toString(), mes.getText().toString());
                        if (datosGuardados) {
                            // Se cambia de actividad
                            startActivity(intent2);
                        } else {
                            Toast.makeText(Activity_registro_plastico.this, "Error al guardar el archivo",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    // Algunos campos están vacíos
                    Toast.makeText(Activity_registro_plastico.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    /**
     * Verifica si un mes existe en el archivo "plastico".
     * @param mesBuscado El mes a buscar.
     * @return true si el mes existe, false en caso contrario.
     */
    public boolean verificarMes(String mesBuscado) {
        File file = new File(getFilesDir(), "plastico.txt");
        mesBuscado = mesBuscado.toLowerCase();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String mes = linea.split(",")[2]; // Suponiendo que el mes está en la tercera columna separada por coma (,)
                if (mes.equalsIgnoreCase(mesBuscado)) {
                    bufferedReader.close();
                    return true; // El mes existe
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // El mes no existe
    }
    /**
     * Guarda los datos en el archivo "plastico.txt" si el mes no existe.
     *
     * @param volumen El volumen a guardar.
     * @param precio  El precio a guardar.
     * @param mes     El mes a guardar.
     * @return true si se guarda correctamente, false en caso contrario.
     */
    public boolean guardarDatos(String volumen, String precio, String mes) {
        File file = new File(getFilesDir(), "plastico.txt");
        mes = mes.toLowerCase();
        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de plastico y escribir los datos en el archivo
            Plastico plastico = new Plastico(Float.parseFloat(volumen), Float.parseFloat(precio), mes);
            String linea = String.format(Locale.getDefault(), "%.2f,%.2f,%s", plastico.getVolumen(), plastico.getPrecio(), plastico.getMes());
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; // Los datos se guardaron correctamente
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Error al guardar los datos
    }
}