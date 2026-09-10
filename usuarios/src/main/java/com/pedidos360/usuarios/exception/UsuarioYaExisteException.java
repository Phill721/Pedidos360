package com.pedidos360.usuarios.exception;

public class UsuarioYaExisteException extends RuntimeException {

    public UsuarioYaExisteException(String message) {
        super(message);
    }
}
