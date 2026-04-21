package org.example.backend.service

import org.example.backend.model.EstadisticaJugador

interface EstadisticaJugadorService {

    fun crear(estadistica: EstadisticaJugador): EstadisticaJugador
    fun listar(): List<EstadisticaJugador>
    fun obtenerPorId(id: Long): EstadisticaJugador
    fun actualizar(id: Long, estadistica: EstadisticaJugador): EstadisticaJugador
    fun eliminar(id: Long)
    fun totalGolesEquipo(id: Long): Int
}