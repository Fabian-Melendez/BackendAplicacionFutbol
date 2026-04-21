package org.example.backend.model


import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "equipo")
data class Equipo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idEquipo: Long = 0,

    @Column(nullable = false)
    val nombre: String,

    val ciudad: String,

    val fundacion: LocalDate
)