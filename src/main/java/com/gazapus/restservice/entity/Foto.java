package com.gazapus.restservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "foto")
public class Foto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @MapsId("recetaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECETA_ID")
    private Receta receta;

    @Column(name = "IMAGEN", nullable = false)
    private byte[] imagen;

    @Column(name = "ES_PRINCIPAL", nullable = false)
    private Boolean esPrincipal = false;

}