package org.example.backend.controller

import org.example.backend.model.Equipo
import org.example.backend.service.EquipoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/equipos")
class EquipoController(
    private val service: EquipoService
) {

    @PostMapping
    fun guardar(@RequestBody e: Equipo) =
        service.guardar(e)

    @GetMapping
    fun listar() =
        service.listar()

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long) =
        service.obtenerPorId(id)

    @PutMapping("/{id}")
    fun actualizar(
        @PathVariable id: Long,
        @RequestBody e: Equipo
    ) = service.actualizar(id, e)

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long) =
        service.eliminar(id)
}