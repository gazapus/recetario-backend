package com.gazapus.restservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", length = 45)
    private String nombre;

    @Column(name = "ALIAS", nullable = false, length = 45)
    private String alias;

    @Column(name = "EMAIL", nullable = false, length = 45)
    private String email;

    @Column(name = "FECHA_ALTA", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "VERIFICADO", nullable = false)
    private Integer verificado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Favorito> favoritos = new LinkedHashSet<>();

}