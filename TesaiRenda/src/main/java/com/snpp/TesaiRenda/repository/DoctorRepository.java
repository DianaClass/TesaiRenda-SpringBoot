package com.snpp.TesaiRenda.repository;

import com.snpp.TesaiRenda.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

   
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar doctores por especialidad
    // =====================================================
    @Query("SELECT d FROM Doctor d WHERE d.especialidad = ?1")
    List<Doctor> buscarPorEspecialidad(String especialidad);

}