package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.RolDTO;
import com.upc.ecochipstf.interfaces.IRolService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RolController {
    @Autowired
    private IRolService rolService;

    @PostMapping("/registrarRol")
    public RolDTO registrar(@Valid @RequestBody RolDTO rolesDTO){ //wrapper
        return rolService.registrar(rolesDTO);
    }

    @GetMapping("/listarRoles")
    public List<RolDTO> findAll(){
        return rolService.findAll();
    }

    @DeleteMapping("/eliminarRol/{id}")
    public void eliminar(@PathVariable Long id){
        rolService.eliminarRol(id);
    }

    @PutMapping("/editarRol")
    public ResponseEntity<RolDTO> editarRol(@RequestBody RolDTO rolesDTO){
        return ResponseEntity.ok(rolService.actualizar(rolesDTO));
    }

}