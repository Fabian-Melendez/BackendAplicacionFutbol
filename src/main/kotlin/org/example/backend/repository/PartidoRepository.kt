package org.example.backend.repository

import org.example.backend.model.Partido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PartidoRepository : JpaRepository<Partido, Long> {

    @Query(
        value = """
        SELECT el.nombre, ev.nombre, p.goles_local, p.goles_visita
        FROM partido p
        JOIN equipo el ON p.equipo_local = el.id_equipo
        JOIN equipo ev ON p.equipo_visita = ev.id_equipo
        """,
        nativeQuery = true
    )
    fun resultadosPartidos(): List<Array<Any>>
}