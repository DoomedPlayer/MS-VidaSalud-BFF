package com.BinarySeint.vsBFF.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BinarySeint.vsBFF.service.AuditClient;
import com.BinarySeint.vsBFF.service.CatalogClient;
import com.BinarySeint.vsBFF.service.CitasClient;
import com.BinarySeint.vsBFF.service.ReportClient;


@RestController
@RequestMapping("/api/bff")
public class BffController {

    private final CatalogClient catalogClient;
    private final CitasClient citasClient; // Corregido a camelCase
    private final ReportClient reportClient;
    private final AuditClient auditClient;

    public BffController(CatalogClient catalogClient, 
                         CitasClient citasClient,
                         ReportClient reportClient,
                         AuditClient auditClient) {
        this.catalogClient = catalogClient;
        this.citasClient = citasClient;
        this.reportClient = reportClient;
        this.auditClient = auditClient;
    }

    @PostMapping("/appointments")
    public ResponseEntity<Object> proxyCreateAppointment(@RequestBody Object atencion) {
        return citasClient.createAppointment(atencion);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Object> proxyGetAppointment(@PathVariable Long id) {
        return citasClient.getAppointment(id);
    }

    @PutMapping("/appointments/{id}/status")
    public ResponseEntity<Object> proxyUpdateAppointmentStatus(@PathVariable Long id, @RequestBody Object body) {
        return citasClient.updateStatus(id, body);
    }

    @GetMapping("/appointments")
    public ResponseEntity<Object> proxyGetAppointments(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {
        return citasClient.getAppointments(status, from, to);
    }

    @GetMapping("/catalog/services")
    public ResponseEntity<Object> proxyGetCatalogServices() {
        return catalogClient.getServices();
    }

    @PostMapping("/catalog/services")
    public ResponseEntity<Object> proxyCreateService(@RequestBody Object prestacion) {
        return catalogClient.createService(prestacion);
    }

    @PutMapping("/catalog/services/{id}")
    public ResponseEntity<Object> proxyUpdateServicePrice(@PathVariable Long id, @RequestBody Object body) {
        return catalogClient.updateServicePrice(id, body);
    }

    @GetMapping("/catalog/cupos")
    public ResponseEntity<Object> proxyGetCupos(@RequestParam(required = false) Boolean disponible) {
        return catalogClient.getCupos(disponible);
    }

    @PostMapping("/catalog/cupos")
    public ResponseEntity<Object> proxyCreateCupo(@RequestBody Object cupo) {
        return catalogClient.createCupo(cupo);
    }

    @GetMapping("/catalog/boxes")
    public ResponseEntity<Object> proxyGetBoxes() {
        return catalogClient.getBoxes();
    }

    @PostMapping("/catalog/boxes")
    public ResponseEntity<Object> proxyCreateBox(@RequestBody Object box) {
        return catalogClient.createBox(box);
    }

    @GetMapping("/report/kpis/today")
    public ResponseEntity<Object> proxyGetKpisToday() {
        return reportClient.getKpisToday();
    }

    @GetMapping("/report/top-services")
    public ResponseEntity<Object> proxyGetTopServices(@RequestParam(required = false) String range) {
        return reportClient.getTopServices(range);
    }

    @GetMapping("/audit")
    public ResponseEntity<Object> proxyGetAllAudits() {
        return auditClient.getAllAudits();
    }

    @PostMapping("/audit/event")
    public ResponseEntity<Object> proxyCreateEvent(@RequestBody Object event) {
        return auditClient.createEvent(event);
    }
    
}