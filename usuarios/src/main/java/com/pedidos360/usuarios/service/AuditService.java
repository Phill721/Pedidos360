package com.pedidos360.usuarios.service;


import org.springframework.data.domain.Page;

import com.pedidos360.usuarios.dto.AuditLogResponse;
import com.pedidos360.usuarios.model.EstadoIntento;
import com.pedidos360.usuarios.model.TipoEvento;

public interface AuditService {
    
    void registrarIntentoFallido(String usuarioAutenticado, TipoEvento tipoEvento, 
                                 EstadoIntento estado, String descripcion, 
                                 Long idUsuarioAfectado, String emailUsuarioAfectado);
    
    Page<AuditLogResponse> listarAuditorias(int page, int size);
    
    Page<AuditLogResponse> listarAuditoriasPorUsuario(String usuarioAutenticado, int page, int size);
}