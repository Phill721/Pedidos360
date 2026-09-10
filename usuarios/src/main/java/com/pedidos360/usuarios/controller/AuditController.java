package com.pedidos360.usuarios.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos360.usuarios.dto.AuditLogResponse;
import com.pedidos360.usuarios.dto.PageResponse;
import com.pedidos360.usuarios.service.AuditService;

@RestController
@RequestMapping("/api/auditoria")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRACION')")
    public ResponseEntity<PageResponse<AuditLogResponse>> listarAuditorias(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Page<AuditLogResponse> resultado = auditService.listarAuditorias(page, size);
        return ResponseEntity.ok(PageResponse.from(resultado));
    }

    @GetMapping("/usuario/{usuarioAutenticado}")
    @PreAuthorize("hasAuthority('ADMINISTRACION')")
    public ResponseEntity<PageResponse<AuditLogResponse>> listarAuditoriasPorUsuario(
            @PathVariable String usuarioAutenticado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Page<AuditLogResponse> resultado = auditService.listarAuditoriasPorUsuario(usuarioAutenticado, page, size);
        return ResponseEntity.ok(PageResponse.from(resultado));
    }
}