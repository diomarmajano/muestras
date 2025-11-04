package com.muestras.muestras.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "muestras")
public class Muestras extends RepresentationModel<Muestras>{
    @Getter @Setter 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @NotNull
    @Column(name = "codigo")
    private String codigo;

    @Getter @Setter
    @NotNull
    @Column(name = "fecha")
    private String fecha;

    @Getter @Setter
    @NotNull
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El nombre solo debe tener letras")
    @Column(name = "nombre_paciente")
    private String nombre_paciente;

    @Getter @Setter
    @NotNull
    @Column(name = "tipo_examen")
    private String tipo_examen;

    @Getter @Setter
    @NotNull
    @Column(name = "resultados")
    private String resultados;

    @Getter @Setter
    @NotNull
    @Column(name = "diagnostico")
    private String diagnostico;
}

