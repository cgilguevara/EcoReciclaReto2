package com.example.reto02.modelo;

public class Plastico {

    private float volumen;
    private float precio;
    private String mes;

    public Plastico (float volumen, float precio, String mes) {
        this.volumen = volumen;
        this.precio = precio;
        this.mes = mes;
    }
    public float getVolumen() {
        return volumen;
    }
    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
}