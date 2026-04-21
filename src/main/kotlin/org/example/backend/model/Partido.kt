package org.example.backend.model


import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "partido")
data class Partido(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idPartido: Long = 0,

    val fecha: LocalDate,

    val estadio: String,

    val equipoLocal: Long,

    val equipoVisita: Long,

    val golesLocal: Int,

    val golesVisita: Int
)