package org.example.backend.service

import org.example.backend.model.Partido
import org.example.backend.repository.PartidoRepository
import org.springframework.stereotype.Service

@Service
class PartidoServiceImpl(
    private val repo: PartidoRepository
) : PartidoService {

    override fun listar(): List<Partido> =
        repo.findAll()

    override fun guardar(partido: Partido): Partido =
        repo.save(partido)

    override fun obtenerPorId(id: Long): Partido =
        repo.findById(id).orElseThrow {
            RuntimeException("Partido no encontrado con id $id")
        }

    override fun actualizar(id: Long, partido: Partido): Partido {
        val existente = obtenerPorId(id)
        val actualizado = existente.copy(
            fecha = partido.fecha,
            equipoLocal = partido.equipoLocal,
            equipoVisita = partido.equipoVisita,
            golesLocal = partido.golesLocal,
            golesVisita = partido.golesVisita
        )
        return repo.save(actualizado)
    }

    override fun eliminar(id: Long) =
        repo.deleteById(id)

    override fun resultados(): List<Array<Any>> =
        repo.resultadosPartidos()
}