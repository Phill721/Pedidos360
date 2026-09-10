package com.pedidos360.usuarios.dto;

import java.util.List;

import com.pedidos360.usuarios.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String nombre;
    private Rol rol;
    private String permiso;
    private List<String> permisos;
}