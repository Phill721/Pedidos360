package com.pedidos360.bff.dto;
import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;
    private String contrasena;
}