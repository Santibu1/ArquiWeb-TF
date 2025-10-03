package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.EmpresaDTO;
import com.upc.ecochipstf.entities.Empresa;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.interfaces.IEmpresaService;
import com.upc.ecochipstf.repositorios.EmpresaRepository;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService implements IEmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO) {
        Usuario usuario = usuarioRepository.findById(empresaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + empresaDTO.getUsuarioId()));

        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
        empresa.setUsuario(usuario);
        empresa.setEstado("Activa"); // por defecto
        empresa = empresaRepository.save(empresa);
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

    @Override
    public List<EmpresaDTO> listarEmpresasActivas() {
        return empresaRepository.findByEstado("Activa")
                .stream()
                .map(emp -> modelMapper.map(emp, EmpresaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmpresaDTO obtenerEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .map(emp -> modelMapper.map(emp, EmpresaDTO.class))
                .orElseThrow(() -> new RuntimeException("Empresa con ID " + id + " no encontrada"));
    }

    @Override
    public EmpresaDTO actualizarEmpresa(EmpresaDTO empresaDTO) {
        return empresaRepository.findById(empresaDTO.getEmpresaId())
                .map(existing -> {
                    Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
                    empresa.setUsuario(existing.getUsuario()); // mantener el usuario original
                    Empresa guardado = empresaRepository.save(empresa);
                    return modelMapper.map(guardado, EmpresaDTO.class);
                })
                .orElseThrow(() -> new RuntimeException("Empresa con ID " + empresaDTO.getEmpresaId() + " no encontrada"));
    }

    @Override
    @Transactional
    public void eliminarEmpresa(Long id) {
        empresaRepository.findById(id).ifPresent(empresa -> {
            empresa.setEstado("Inactiva"); // baja lógica
            empresaRepository.save(empresa);
        });
    }
}
