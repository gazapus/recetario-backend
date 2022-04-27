package com.gazapus.restservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "paso")
public class Paso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @MapsId("recetaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECETA_ID")
    private Receta receta;

    @Column(name = "DESCRIPCION", length = 45)
    private String descripcion;

    @Column(name = "ORDEN", nullable = false)
    private Integer orden;

}