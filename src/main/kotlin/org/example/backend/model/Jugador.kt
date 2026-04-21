package org.example.backend.model


import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "jugador")
data class Jugador(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idJugador: Long = 0,

    val nombre: String,

    val posicion: String,

    val dorsal: Int,

    val fechaNac: LocalDate,

    val nacionalidad: String,

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    val equipo: Equipo
)