package org.example.backend.controller

import org.example.backend.model.Jugador
import org.example.backend.service.JugadorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jugadores")
class JugadorController(
    private val service: JugadorService
) {

    @GetMapping
    fun listar() = service.listar()

    @PostMapping
    fun guardar(@RequestBody j: Jugador) = service.guardar(j)

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long) = service.eliminar(id)

    @GetMapping("/equipo/{id}")
    fun porEquipo(@PathVariable id: Long) = service.porEquipo(id)

    @GetMapping("/goleadores/{goles}")
    fun goleadores(@PathVariable goles: Int) = service.goleadores(goles)
}