package com.snpp.TesaiRenda.service;

import java.util.List;

import com.snpp.TesaiRenda.entity.Cita;

public interface CitaService {

    List<Cita> listarTodos();

    Cita buscarPorId(Long id);

    Cita guardar(Cita cita);

    Cita actualizar(Long id, Cita cita);

    void eliminar(Long id);

    
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar todas las citas por estado
    // =====================================================
    List<Cita> buscarPorEstado(String estado);

}