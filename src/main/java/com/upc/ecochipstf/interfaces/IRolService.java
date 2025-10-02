package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.RolDTO;

import java.util.List;

public interface IRolService {
    public RolDTO registrar(RolDTO rolDTO);
    public List<RolDTO> findAll();
    public void eliminarRol(Long idRol);
    public RolDTO actualizar(RolDTO rolDTO);

}
