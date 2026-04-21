package org.example.backend.service

import org.example.backend.model.Jugador
import org.example.backend.repository.JugadorRepository
import org.springframework.stereotype.Service

@Service
class JugadorServiceImpl(
    private val repo: JugadorRepository
) : JugadorService {

    override fun listar(): List<Jugador> =
        repo.findAll()

    override fun guardar(jugador: Jugador): Jugador =
        repo.save(jugador)

    override fun obtenerPorId(id: Long): Jugador =
        repo.findById(id).orElseThrow {
            RuntimeException("Jugador no encontrado con id $id")
        }

    override fun actualizar(id: Long, jugador: Jugador): Jugador {
        val existente = obtenerPorId(id)

        val actualizado = existente.copy(
            nombre = jugador.nombre,
            posicion = jugador.posicion,
            dorsal = jugador.dorsal,
            fechaNac = jugador.fechaNac,
            nacionalidad = jugador.nacionalidad,
            equipo = jugador.equipo
        )

        return repo.save(actualizado)
    }

    override fun eliminar(id: Long) =
        repo.deleteById(id)

    override fun porEquipo(id: Long): List<Jugador> =
        repo.findByEquipo(id)

    override fun goleadores(goles: Int): List<Jugador> =
        repo.jugadoresConMasDeXGoles(goles)
}