package com.snpp.TesaiRenda.impl;

import com.snpp.TesaiRenda.entity.Cita;
import com.snpp.TesaiRenda.repository.CitaRepository;
import com.snpp.TesaiRenda.service.CitaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> listarTodos() {
        return citaRepository.findAll();
    }

    @Override
    public Cita buscarPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Cita actualizar(Long id, Cita cita) {
        cita.setIdCita(id);
        return citaRepository.save(cita);
    }

    @Override
    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar todas las citas por estado
    // =====================================================
    @Override
    public List<Cita> buscarPorEstado(String estado) {
        return citaRepository.buscarPorEstado(estado);
    }
}