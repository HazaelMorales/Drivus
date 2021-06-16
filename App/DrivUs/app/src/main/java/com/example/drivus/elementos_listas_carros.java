package com.example.drivus;

public class elementos_listas_carros {
    public String nombre;
    public String marca;
    public String precio;
    public String anioo;
    public String kilometraje;
    public String combustible;
    public String cambios;
    public String status;
    public String hora;
    public String fecha;

    public elementos_listas_carros(String nombre, String marca, String precio, String anioo, String kilometraje, String combustible, String cambios, String status, String hora, String fecha) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.anioo = anioo;
        this.kilometraje = kilometraje;
        this.combustible = combustible;
        this.cambios = cambios;
        this.status = status;
        this.hora = hora;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getAnioo() {
        return anioo;
    }

    public void setAnioo(String anioo) {
        this.anioo = anioo;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getCambios() {
        return cambios;
    }

    public void setCambios(String cambios) {
        this.cambios = cambios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}
