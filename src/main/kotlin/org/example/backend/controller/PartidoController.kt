package org.example.backend.controller

import org.example.backend.model.Partido
import org.example.backend.service.PartidoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partidos")
class PartidoController(
    private val service: PartidoService
) {

    @PostMapping
    fun guardar(@RequestBody partido: Partido) =
        service.guardar(partido)

    @GetMapping
    fun listar() =
        service.listar()

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long) =
        service.obtenerPorId(id)

    @PutMapping("/{id}")
    fun actualizar(
        @PathVariable id: Long,
        @RequestBody partido: Partido
    ) = service.actualizar(id, partido)
    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long) =
        service.eliminar(id)

    @GetMapping("/resultados")
    fun resultados() =
        service.resultados()
}