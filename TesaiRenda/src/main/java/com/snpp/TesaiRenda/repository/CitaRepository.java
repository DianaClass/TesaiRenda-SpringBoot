package com.snpp.TesaiRenda.repository;

import com.snpp.TesaiRenda.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar todas las citas por estado
    // Ejemplo: Pendiente, Confirmada, Cancelada, Finalizada
    // =====================================================
    @Query("SELECT c FROM Cita c WHERE c.estado = ?1")
    List<Cita> buscarPorEstado(String estado);

}