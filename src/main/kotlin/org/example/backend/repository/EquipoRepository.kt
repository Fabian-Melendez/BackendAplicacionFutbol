package org.example.backend.repository

import org.example.backend.model.Equipo
import org.springframework.data.jpa.repository.JpaRepository

interface EquipoRepository : JpaRepository<Equipo, Long>