package com.snpp.TesaiRenda.controller;


import com.snpp.TesaiRenda.entity.Doctor;
import com.snpp.TesaiRenda.service.DoctorService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctores")
@CrossOrigin(origins = "*") // Permite que Swagger Web pueda consultar este controlador
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> listarTodos() {
        return doctorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Doctor buscarPorId(@PathVariable Long id) {
        return doctorService.buscarPorId(id);
    }

    @PostMapping
    public Doctor guardar(@RequestBody Doctor doctor) {
        return doctorService.guardar(doctor);
    }

    @PutMapping("/{id}")
    public Doctor actualizar(@PathVariable Long id,
                             @RequestBody Doctor doctor) {
        return doctorService.actualizar(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        doctorService.eliminar(id);
    }

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar doctores por especialidad
    // URL: GET /doctores/especialidad/{especialidad}
    // Ejemplo:
    // http://localhost:8081/snpp/doctores/especialidad/Cardiologia
    // =====================================================
    @GetMapping("/especialidad/{especialidad}")
    public List<Doctor> buscarPorEspecialidad(@PathVariable String especialidad) {
        return doctorService.buscarPorEspecialidad(especialidad);
    }
}