package com.gazapus.restservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<TipoComida> tiposDeComida = new ArrayList<>();

    @OneToMany(mappedBy = "receta")
    private List<IngredienteReceta> ingredienteRecetas = new ArrayList<>();

    @OneToMany(mappedBy = "receta", fetch = FetchType.LAZY)
	@OrderBy("esPrincipal asc, id asc")
	private List<Foto> fotos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receta")
	@OrderBy("orden asc")
	private List<Paso> pasos = new ArrayList<>();
}