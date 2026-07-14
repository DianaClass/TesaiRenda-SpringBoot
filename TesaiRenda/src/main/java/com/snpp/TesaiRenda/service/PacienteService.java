package com.snpp.TesaiRenda.service;

import java.util.List;

import com.snpp.TesaiRenda.entity.Paciente;

public interface PacienteService {

    List<Paciente> listarTodos();

    Paciente buscarPorId(Long id);

    Paciente guardar(Paciente paciente);

    Paciente actualizar(Long id, Paciente paciente);

    void eliminar(Long id);

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Listar todos los pacientes activos
    // =====================================================
    List<Paciente> listarPacientesActivos();

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #2
    // Descripción: Buscar paciente por su número de cédula
    // =====================================================
    Paciente buscarPorCedula(String cedula);

}