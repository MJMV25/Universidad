package org.example.interfaces;

import org.example.domain.Universidad;

import java.util.List;

 public interface UniversidadService {
    void agregarUniversidad(Universidad universidad);
    Universidad obtenerUniversidad(int id);
    List<Universidad> obtenerTodasLasUniversidades();
    void actualizarUniversidad(Universidad universidad);
    void eliminarUniversidad(int id);
}
