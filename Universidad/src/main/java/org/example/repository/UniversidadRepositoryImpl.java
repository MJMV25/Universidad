package org.example.repository;


import org.example.domain.Universidad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UniversidadRepositoryImpl implements UniversidadRepository {
    private List<Universidad> universidades;
    private final String archivo = "universidades.ser";

    public UniversidadRepositoryImpl() {
        universidades = cargarUniversidades();
    }

    @Override
    public void agregarUniversidad(Universidad universidad) {
        universidades.add(universidad);
        guardarUniversidades();
    }

    @Override
    public Universidad obtenerUniversidad(int id) {
        return universidades.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Universidad> obtenerTodasLasUniversidades() {
        return universidades;
    }

    @Override
    public void actualizarUniversidad(Universidad universidad) {
        eliminarUniversidad(universidad.getId());
        agregarUniversidad(universidad);
    }

    @Override
    public void eliminarUniversidad(int id) {
        universidades.removeIf(u -> u.getId() == id);
        guardarUniversidades();
    }

    private void guardarUniversidades() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(universidades);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<Universidad> cargarUniversidades() {
        File file = new File(archivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Universidad>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

