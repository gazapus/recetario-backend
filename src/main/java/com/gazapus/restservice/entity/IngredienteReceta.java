package com.gazapus.restservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingrediente_receta")
public class IngredienteReceta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @MapsId("recetaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECETA_ID")
    private Receta receta;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TIPO_CANTIDAD_ID", nullable = false)
    private TipoCantidad tipoCantidad;

    @Column(name = "CANTIDAD", nullable = false)
    private Double cantidad;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INGREDIENTE_ID", nullable = false, referencedColumnName = "ID")
    private Ingrediente ingrediente;

}