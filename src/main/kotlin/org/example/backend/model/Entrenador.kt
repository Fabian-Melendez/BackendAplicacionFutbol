package org.example.backend.model


import jakarta.persistence.*

@Entity
@Table(name = "entrenador")
data class Entrenador(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idEntrenador: Long = 0,

    val nombre: String,

    val especialidad: String,

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    val equipo: Equipo
)