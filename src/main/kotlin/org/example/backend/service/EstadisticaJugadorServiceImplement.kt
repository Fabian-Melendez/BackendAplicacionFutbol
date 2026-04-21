package org.example.backend.service

import org.example.backend.model.EstadisticaJugador
import org.example.backend.repository.EstadisticaJugadorRepository
import org.springframework.stereotype.Service

@Service
class EstadisticaJugadorServiceImpl(
    private val repo: EstadisticaJugadorRepository
) : EstadisticaJugadorService {

    override fun listar(): List<EstadisticaJugador> =
        repo.findAll()

    override fun crear(estadistica: EstadisticaJugador): EstadisticaJugador =
        repo.save(estadistica)

    override fun obtenerPorId(id: Long): EstadisticaJugador =
        repo.findById(id).orElseThrow {
            RuntimeException("Estadística no encontrada con id $id")
        }

    override fun actualizar(id: Long, estadistica: EstadisticaJugador): EstadisticaJugador {
        val existente = obtenerPorId(id)

        val actualizado = existente.copy(
            jugador = estadistica.jugador,
            partido = estadistica.partido,
            minutosJugados = estadistica.minutosJugados,
            goles = estadistica.goles,
            asistencias = estadistica.asistencias,
            tarjetasAmarillas = estadistica.tarjetasAmarillas,
            tarjetasRojas = estadistica.tarjetasRojas
        )

        return repo.save(actualizado)
    }

    override fun eliminar(id: Long) =
        repo.deleteById(id)

    override fun totalGolesEquipo(id: Long): Int =
        repo.totalGolesEquipo(id)
}