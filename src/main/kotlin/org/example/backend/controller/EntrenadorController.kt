package org.example.backend.controller

import org.example.backend.model.Entrenador
import org.example.backend.service.EntrenadorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/entrenadores")
@CrossOrigin(origins = ["*"])
class EntrenadorController(
    private val service: EntrenadorService
) {

    @PostMapping
    fun guardar(@RequestBody entrenador: Entrenador): Entrenador =
        service.guardar(entrenador)

    @GetMapping
    fun listar(): List<Entrenador> =
        service.listar()

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): Entrenador =
        service.obtenerPorId(id)

    @PutMapping("/{id}")
    fun actualizar(
        @PathVariable id: Long,
        @RequestBody entrenador: Entrenador
    ): Entrenador =
        service.actualizar(id, entrenador)

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long) =
        service.eliminar(id)
}