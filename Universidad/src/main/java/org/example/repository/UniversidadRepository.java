package org.example.repository;


import org.example.domain.Universidad;

import java.util.List;

public interface UniversidadRepository {
    void agregarUniversidad(Universidad universidad);
    Universidad obtenerUniversidad(int id);
    List<Universidad> obtenerTodasLasUniversidades();
    void actualizarUniversidad(Universidad universidad);
    void eliminarUniversidad(int id);
}
