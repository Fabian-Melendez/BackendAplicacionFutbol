package org.example.backend.service

import org.example.backend.model.Equipo
import org.example.backend.repository.EquipoRepository
import org.springframework.stereotype.Service

@Service
class EquipoServiceImpl(
    private val repo: EquipoRepository
) : EquipoService {

    override fun listar(): List<Equipo> =
        repo.findAll()

    override fun guardar(equipo: Equipo): Equipo =
        repo.save(equipo)

    override fun obtenerPorId(id: Long): Equipo =
        repo.findById(id).orElseThrow {
            RuntimeException("Equipo no encontrado con id $id")
        }

    override fun actualizar(id: Long, equipo: Equipo): Equipo {
        val existente = obtenerPorId(id)
        val actualizado = existente.copy(
            // 🔧 ajusta según tu modelo
            nombre = equipo.nombre
        )
        return repo.save(actualizado)
    }

    override fun eliminar(id: Long) =
        repo.deleteById(id)
}