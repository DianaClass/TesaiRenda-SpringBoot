package com.snpp.TesaiRenda.impl;


import com.snpp.TesaiRenda.entity.Doctor;
import com.snpp.TesaiRenda.repository.DoctorRepository;
import com.snpp.TesaiRenda.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> listarTodos() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor buscarPorId(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor guardar(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor actualizar(Long id, Doctor doctor) {
        doctor.setIdDoctor(id);
        return doctorRepository.save(doctor);
    }

    @Override
    public void eliminar(Long id) {
        doctorRepository.deleteById(id);
    }

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar doctores por especialidad
    // =====================================================
    @Override
    public List<Doctor> buscarPorEspecialidad(String especialidad) {
        return doctorRepository.buscarPorEspecialidad(especialidad);
    }
}