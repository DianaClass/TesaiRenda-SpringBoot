package com.snpp.TesaiRenda.repository;

import com.snpp.TesaiRenda.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional; // ¡Importante para el findByCedula!

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #1
    // (Aquí seguro tienes tu consulta de pacientes activos con @Query)
    // =====================================================
    @Query("SELECT p FROM Paciente p WHERE p.activo = true") // O como la tengas programada
    List<Paciente> listarPacientesActivos();

    // =====================================================
    // CONSULTA PERSONALIZADA #2
    // Descripción: Spring Data JPA creará la query automáticamente
    // =====================================================
    Optional<Paciente> findByCedula(String cedula);
}