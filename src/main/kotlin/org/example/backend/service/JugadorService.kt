package org.example.backend.service

import org.example.backend.model.Jugador

interface JugadorService {

    fun listar(): List<Jugador>

    fun guardar(jugador: Jugador): Jugador

    fun obtenerPorId(id: Long): Jugador

    fun actualizar(id: Long, jugador: Jugador): Jugador

    fun eliminar(id: Long)

    fun porEquipo(id: Long): List<Jugador>

    fun goleadores(goles: Int): List<Jugador>
}