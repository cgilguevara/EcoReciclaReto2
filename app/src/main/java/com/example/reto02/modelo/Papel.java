package com.example.reto02.modelo;

public class Papel {
    private float hojas;
    private float precio;
    private String mes;

    public Papel(float hojas, float precio, String mes) {
        hojas = hojas;
        this.precio = precio;
        this.mes = mes;
    }

    public float getHojas() {
        return hojas;
    }

    public void setHojas(float hojas) { hojas = hojas; }
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
