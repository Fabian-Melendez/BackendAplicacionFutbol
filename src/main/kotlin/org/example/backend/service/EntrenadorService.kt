package org.example.backend.service

import org.example.backend.model.Entrenador

interface EntrenadorService {

    fun listar(): List<Entrenador>

    fun guardar(entrenador: Entrenador): Entrenador

    fun obtenerPorId(id: Long): Entrenador

    fun actualizar(id: Long, entrenador: Entrenador): Entrenador

    fun eliminar(id: Long)
}