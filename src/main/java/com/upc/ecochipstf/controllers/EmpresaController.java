package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.EmpresaDTO;
import com.upc.ecochipstf.interfaces.IEmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaController {
    @Autowired
    private IEmpresaService empresaService;

    @PostMapping("/Registrar-Empresa")
    public EmpresaDTO crearEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
        return empresaService.crearEmpresa(empresaDTO);
    }

    @GetMapping("/Listar-Empresas-Activas")
    public List<EmpresaDTO> listarEmpresasActivas() {
        return empresaService.listarEmpresasActivas();
    }

    @GetMapping("/Listar-Empresa-Por/{id}")
    public EmpresaDTO obtenerEmpresaPorId(@PathVariable Long id) {
        return empresaService.obtenerEmpresaPorId(id);
    }

    @PutMapping("/Actualizar-Empresa/{id}")
    public EmpresaDTO actualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaDTO empresaDTO) {
        empresaDTO.setEmpresaId(id);
        return empresaService.actualizarEmpresa(empresaDTO);
    }

    @DeleteMapping("/Eliminar-Empresa/{id}")
    public void eliminarEmpresa(@PathVariable Long id) {
        empresaService.eliminarEmpresa(id);
    }
}
