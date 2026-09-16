package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "appointments-svc", url = "http://appointments-svc:8080/api/appointments")
public interface CitasClient {
    @PostMapping
    ResponseEntity<Object> createAppointment(@RequestBody Object atencion);
    
    @GetMapping("/{id}")
    ResponseEntity<Object> getAppointment(@PathVariable("id") Long id);
    
    @PutMapping("/{id}/status")
    ResponseEntity<Object> updateStatus(@PathVariable("id") Long id, @RequestBody Object body);
    
    @GetMapping
    ResponseEntity<Object> getAppointments(@RequestParam(value = "status", required = false) String status,
                                           @RequestParam(value = "from", required = false) String from,
                                           @RequestParam(value = "to", required = false) String to);
}