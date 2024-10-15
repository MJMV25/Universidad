package org.example.interfaces;


import org.example.domain.Universidad;
import org.example.repository.UniversidadRepository;


import java.util.List;

public class UniversidadServiceImpl implements UniversidadService {
    private final UniversidadRepository universidadRepository;

    public UniversidadServiceImpl(UniversidadRepository universidadRepository) {
        this.universidadRepository = universidadRepository;
    }

    @Override
    public void agregarUniversidad(Universidad universidad) {
        universidadRepository.agregarUniversidad(universidad);
    }

    @Override
    public Universidad obtenerUniversidad(int id) {
        return universidadRepository.obtenerUniversidad(id);
    }

    @Override
    public List<Universidad> obtenerTodasLasUniversidades() {
        return universidadRepository.obtenerTodasLasUniversidades();
    }

    @Override
    public void actualizarUniversidad(Universidad universidad) {
        universidadRepository.actualizarUniversidad(universidad);
    }

    @Override
    public void eliminarUniversidad(int id) {
        universidadRepository.eliminarUniversidad(id);
    }
}

