package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.EmpresaDTO;

import java.util.List;

public interface IEmpresaService {
    public EmpresaDTO crearEmpresa(EmpresaDTO empresaDTO);
    public List<EmpresaDTO> listarEmpresasActivas();
    public EmpresaDTO obtenerEmpresaPorId(Long id);
    public EmpresaDTO actualizarEmpresa(EmpresaDTO empresaDTO);
    public void eliminarEmpresa(Long id);
}
