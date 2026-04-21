package org.example.backend.repository

import org.example.backend.model.Jugador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface JugadorRepository : JpaRepository<Jugador, Long> {

    @Query(
        value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo",
        nativeQuery = true
    )
    fun findByEquipo(@Param("idEquipo") idEquipo: Long): List<Jugador>

    @Query(
        value = """
        SELECT j.* FROM jugador j
        JOIN estadistica_jugador e ON j.id_jugador = e.id_jugador
        GROUP BY j.id_jugador
        HAVING SUM(e.goles) > :goles
        """,
        nativeQuery = true
    )
    fun jugadoresConMasDeXGoles(@Param("goles") goles: Int): List<Jugador>
}