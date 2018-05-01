package com.example.juanamado.examen.modelos;

import android.graphics.drawable.Drawable;

public class DetalleProducto extends BasicModel {

    private Drawable imagen;
    private String name;
    private String precio;

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
