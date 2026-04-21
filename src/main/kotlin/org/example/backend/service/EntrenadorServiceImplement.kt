package org.example.backend.service

import org.example.backend.model.Entrenador
import org.example.backend.repository.EntrenadorRepository
import org.springframework.stereotype.Service

@Service
class EntrenadorServiceImpl(
    private val repo: EntrenadorRepository
) : EntrenadorService {

    override fun listar(): List<Entrenador> =
        repo.findAll()

    override fun guardar(entrenador: Entrenador): Entrenador =
        repo.save(entrenador)

    override fun obtenerPorId(id: Long): Entrenador =
        repo.findById(id).orElseThrow {
            RuntimeException("Entrenador no encontrado con id $id")
        }

    override fun actualizar(id: Long, entrenador: Entrenador): Entrenador {
        val existente = obtenerPorId(id)
        val actualizado = existente.copy(
            nombre = entrenador.nombre
        )
        return repo.save(actualizado)
    }

    override fun eliminar(id: Long) =
        repo.deleteById(id)
}