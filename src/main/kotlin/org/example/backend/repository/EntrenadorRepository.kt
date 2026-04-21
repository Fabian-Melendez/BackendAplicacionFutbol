package org.example.backend.repository

import org.example.backend.model.Entrenador
import org.springframework.data.jpa.repository.JpaRepository

interface EntrenadorRepository : JpaRepository<Entrenador, Long>