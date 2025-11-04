package com.muestras.muestras.controller;

import com.muestras.muestras.model.Muestras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import com.muestras.muestras.service.MuestrasService;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resultados")
@CrossOrigin("*")
public class MuestrasController {

    @Autowired
    private MuestrasService muestrasService;

    @PostMapping
    public EntityModel<Muestras>createMuestras(@RequestBody Muestras muestras) {
        Muestras createdMuestra = muestrasService.createMuestras(muestras);
        return EntityModel.of(createdMuestra);
    }

    @GetMapping
     public CollectionModel<EntityModel<Muestras>> getAllMuestras() {
        List<Muestras> muestras = muestrasService.getAllMuestras();
        List<EntityModel<Muestras>> muestrasResources = muestras.stream()
                .map(EntityModel::of)
                .collect(Collectors.toList());

        return CollectionModel.of(muestrasResources);
        }

     @PutMapping("/{id}")
     public EntityModel<Muestras>updateMuestras(@PathVariable Long id, @RequestBody Muestras muestras) {
        Optional<Muestras> existingMuestra = muestrasService.findMuestrasById(id);
         if (existingMuestra.isPresent()) {
             Muestras updatedMuestra= muestrasService.updateMuestras(id, muestras);
             return EntityModel.of(updatedMuestra);
         }
         return null;
     }

     @DeleteMapping("/{id}")
     public EntityModel<String> deleteMuestrasById(@PathVariable Long id) {
        muestrasService.deleteMuestrasById(id);
        return null;
    }
}
