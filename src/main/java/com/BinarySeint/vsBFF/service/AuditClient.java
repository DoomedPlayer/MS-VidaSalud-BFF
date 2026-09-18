package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "audit-client", url = "http://audit-svc:8080/api/audit")
public interface AuditClient {
    @GetMapping
    ResponseEntity<Object> getAllAudits();
    @PostMapping("/event")
    ResponseEntity<Object> createAudit(@RequestBody Object evento);
}