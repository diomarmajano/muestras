package com.muestras.muestras.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muestras.muestras.model.Muestras;
import com.muestras.muestras.repository.MuestrasRepository;
import jakarta.annotation.PostConstruct;

@Service
public class MuestrasServiceImpl implements MuestrasService {
    
     @Autowired
    private MuestrasRepository muestrasRepository;

    @Override
    public Muestras createMuestras(Muestras muestras) {
        return muestrasRepository.save(muestras);
    }

    @Override
     public Muestras updateMuestras(Long id, Muestras muestras) {
        if(muestrasRepository.existsById(id)){
            muestras.setId(id);
            return muestrasRepository.save(muestras);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteMuestrasById(Long id) {
        if(muestrasRepository.existsById(id)){
            muestrasRepository.deleteById(id);
        }
    }

     @Override
    public List<Muestras> getAllMuestras(){
        return muestrasRepository.findAll();
    }

    @Override
    public Optional<Muestras> findMuestrasById(Long id) {
        return muestrasRepository.findById(id);
    }

    @PostConstruct
    public void init(){
        Muestras muestra1 = new Muestras();
        muestra1.setCodigo("1EGR80");
        muestra1.setFecha("2025-11-03");
        muestra1.setNombre_paciente("Juan");
        muestra1.setTipo_examen("sangre");
        muestra1.setResultados("Alterados");
        muestra1.setDiagnostico("Diabetes");

        Muestras muestra2 = new Muestras();

        muestra2.setCodigo("1EPR80");
        muestra2.setFecha("2025-11-03");
        muestra2.setNombre_paciente("Juan");
        muestra2.setTipo_examen("sangre");
        muestra2.setResultados("Alterados");
        muestra2.setDiagnostico("Diabetes");

        Muestras muestra3 = new Muestras();

        muestra3.setCodigo("1EPR80");
        muestra3.setFecha("2025-11-03");
        muestra3.setNombre_paciente("Juan");
        muestra3.setTipo_examen("sangre");
        muestra3.setResultados("negativo");
        muestra3.setDiagnostico("Sin alteraciones en los examenes");

        muestrasRepository.saveAll(List.of(muestra1, muestra2, muestra3));
    }
}
