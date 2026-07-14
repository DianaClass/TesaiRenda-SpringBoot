package com.snpp.TesaiRenda.service;

import java.util.List;

import com.snpp.TesaiRenda.entity.Doctor;

public interface DoctorService {

    List<Doctor> listarTodos();

    Doctor buscarPorId(Long id);

    Doctor guardar(Doctor doctor);

    Doctor actualizar(Long id, Doctor doctor);

    void eliminar(Long id);

  
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar doctores por especialidad
    // =====================================================
    List<Doctor> buscarPorEspecialidad(String especialidad);

}