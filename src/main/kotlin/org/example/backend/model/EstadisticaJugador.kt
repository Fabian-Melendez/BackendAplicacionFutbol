package org.example.backend.model


import jakarta.persistence.*

@Entity
@Table(name = "estadistica_jugador")
data class EstadisticaJugador(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idEstadistica: Long = 0,

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    val jugador: Jugador,

    @ManyToOne
    @JoinColumn(name = "id_partido")
    val partido: Partido,

    val minutosJugados: Int,

    val goles: Int,

    val asistencias: Int,

    val tarjetasAmarillas: Int,

    val tarjetasRojas: Int
)