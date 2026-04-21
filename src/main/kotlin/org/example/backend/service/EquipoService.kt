package org.example.backend.service

import org.example.backend.model.Equipo

interface EquipoService {

    fun listar(): List<Equipo>

    fun guardar(equipo: Equipo): Equipo

    fun obtenerPorId(id: Long): Equipo

    fun actualizar(id: Long, equipo: Equipo): Equipo

    fun eliminar(id: Long)
}