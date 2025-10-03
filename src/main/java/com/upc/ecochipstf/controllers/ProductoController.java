package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.ProductoDTO;
import com.upc.ecochipstf.interfaces.IProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @PostMapping("/Registrar-Producto")
    public ProductoDTO crearProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.crearProducto(productoDTO);
    }

    @GetMapping("/Listar-Productos-Activos")
    public List<ProductoDTO> listarProductosActivos() {
        return productoService.listarProductosActivos();
    }

    @GetMapping("/Productos-Por-Empresa/{empresaId}")
    public List<ProductoDTO> listarProductosPorEmpresa(@PathVariable Long empresaId) {
        return productoService.listarProductosPorEmpresa(empresaId);
    }

    @GetMapping("/Listar-Producto-Por/{id}")
    public ProductoDTO obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PutMapping("/Modificar-Producto/{id}")
    public ProductoDTO actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        productoDTO.setProductoId(id);
        return productoService.actualizarProducto(productoDTO);
    }

    @DeleteMapping("/Eliminar-Producto/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
