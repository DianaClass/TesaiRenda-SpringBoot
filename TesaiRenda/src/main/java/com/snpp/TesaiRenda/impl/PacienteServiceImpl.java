package com.snpp.TesaiRenda.impl;


import com.snpp.TesaiRenda.entity.Paciente;
import com.snpp.TesaiRenda.repository.PacienteRepository;
import com.snpp.TesaiRenda.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizar(Long id, Paciente paciente) {
        paciente.setIdPaciente(id);
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Listar todos los pacientes activos
    // =====================================================
    @Override
    public List<Paciente> listarPacientesActivos() {
        return pacienteRepository.listarPacientesActivos();
    }

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #2
    // Descripción: Buscar paciente por su número de cédula
    // =====================================================
    @Override
    public Paciente buscarPorCedula(String cedula) {
        return pacienteRepository.findByCedula(cedula).orElse(null);
    }
}