package org.example.domain;

import java.io.Serializable;

public class Universidad implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private String direccion;

    public Universidad(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Universidad{id=" + id + ", nombre='" + nombre + '\'' + ", direccion='" + direccion + '\'' + '}';
    }
}
