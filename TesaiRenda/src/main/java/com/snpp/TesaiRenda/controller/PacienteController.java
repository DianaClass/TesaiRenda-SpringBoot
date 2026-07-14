package com.snpp.TesaiRenda.controller;


import com.snpp.TesaiRenda.entity.Paciente;
import com.snpp.TesaiRenda.service.PacienteService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*") // Permite que Swagger Web pueda consultar este controlador
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }

    @PostMapping
    public Paciente guardar(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizar(@PathVariable Long id,
                               @RequestBody Paciente paciente) {
        return pacienteService.actualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }

    // =====================================================
    // CONSULTA PERSONALIZADA JPQL #1
    // Descripción: Buscar paciente por su número de cédula/documento
    // URL: GET /pacientes/cedula/{cedula}
    // Ejemplo:
    // http://localhost:8081/snpp/pacientes/cedula/1234567
    // =====================================================
    @GetMapping("/cedula/{cedula}")
    public Paciente buscarPorCedula(@PathVariable String cedula) {
        return pacienteService.buscarPorCedula(cedula);
    }
}