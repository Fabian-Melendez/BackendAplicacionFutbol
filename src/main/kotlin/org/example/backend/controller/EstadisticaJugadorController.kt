package org.example.backend.controller

import org.example.backend.model.EstadisticaJugador
import org.example.backend.service.EstadisticaJugadorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/estadisticas")
class EstadisticaJugadorController(
    private val service: EstadisticaJugadorService
) {

    @PostMapping
    fun crear(@RequestBody estadistica: EstadisticaJugador): EstadisticaJugador {
        return service.crear(estadistica)
    }

    @GetMapping
    fun listar(): List<EstadisticaJugador> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): EstadisticaJugador {
        return service.obtenerPorId(id)
    }

    @PutMapping("/{id}")
    fun actualizar(
        @PathVariable id: Long,
        @RequestBody estadistica: EstadisticaJugador
    ): EstadisticaJugador {
        return service.actualizar(id, estadistica)
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long) {
        service.eliminar(id)
    }

    @GetMapping("/goles-equipo/{id}")
    fun totalGoles(@PathVariable id: Long) =
        service.totalGolesEquipo(id)
}