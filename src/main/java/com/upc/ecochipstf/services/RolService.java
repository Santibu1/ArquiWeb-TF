package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.RolDTO;
import com.upc.ecochipstf.entities.Rol;
import com.upc.ecochipstf.interfaces.IRolService;
import com.upc.ecochipstf.repositorios.RolRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RolDTO registrar(RolDTO rolesDTO) {//solo si hay administrador sera visible en la pagina
        if (rolesDTO.getRolId() == null) {
            Rol rol = modelMapper.map(rolesDTO, Rol.class);
            rol = rolRepository.save(rol);
            return modelMapper.map(rol, RolDTO.class);
        }
        return null;
    }

    @Override
    public List<RolDTO> findAll() {
        return rolRepository.findAll()
                .stream()
                .map(rol -> modelMapper.map(rol, RolDTO.class))
                .toList();
    }

    @Override
    public void eliminarRol(Long idRol) {//solo si hay administrador sera visible en la pagina
        if(rolRepository.existsById(idRol)) {
            rolRepository.deleteById(idRol);
        }
    }

    @Override
    public RolDTO actualizar(RolDTO rolesDTO) {//solo si hay administrador sera visible en la pagina
        return rolRepository.findById(rolesDTO.getRolId())
                .map(existing -> {
                    Rol rolEntidad = modelMapper.map(rolesDTO, Rol.class);
                    Rol guardado = rolRepository.save(rolEntidad);
                    return modelMapper.map(guardado, RolDTO.class);
                })
                .orElseThrow(() -> new RuntimeException("Receta con ID " + rolesDTO.getRolId() +
                        " no encontrado"));
    }
}
