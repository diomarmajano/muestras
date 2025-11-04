package com.muestras.muestras.service;

import java.util.List;
import java.util.Optional;

import com.muestras.muestras.model.Muestras;

public interface MuestrasService {
    Muestras createMuestras(Muestras muestras);
    Muestras updateMuestras(Long id, Muestras muestras);
    void deleteMuestrasById(Long id);
    List<Muestras> getAllMuestras();
    Optional<Muestras> findMuestrasById(Long id);
}
