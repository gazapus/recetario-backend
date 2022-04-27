package com.gazapus.restservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "receta")
public class Receta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 45)
    private String descripcion;

    @Column(name = "DURACION")
    private Integer duracion;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDate fechaCreacion;

    @ManyToMany
    @JoinTable(name = "tipo_comida_receta",
            joinColumns = @JoinColumn(name = "RECETA_ID"),
            inverseJoinColumns = @JoinColumn(name = "TIPO_COMIDA_ID"))
    private Set<TipoComida> tipoComidas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "receta")
    private Set<IngredienteReceta> ingredienteRecetas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "receta")
    private Set<Foto> fotos = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receta")
    private Set<Paso> pasos = new LinkedHashSet<>();

}