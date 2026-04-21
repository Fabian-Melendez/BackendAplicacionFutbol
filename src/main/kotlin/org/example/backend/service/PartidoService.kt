package org.example.backend.service

import org.example.backend.model.Partido

interface PartidoService {

    fun listar(): List<Partido>

    fun guardar(partido: Partido): Partido

    fun obtenerPorId(id: Long): Partido

    fun actualizar(id: Long, partido: Partido): Partido

    fun eliminar(id: Long)

    fun resultados(): List<Array<Any>>
}