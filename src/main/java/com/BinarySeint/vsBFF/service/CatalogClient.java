package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "catalog-svc", url = "http://catalog-svc:8080/api/catalog")
public interface CatalogClient {
    @GetMapping("/services")
    ResponseEntity<Object> getServices();

    @PostMapping("/services")
    ResponseEntity<Object> createService(@RequestBody Object prestacion);

    @PutMapping("/services/{id}")
    ResponseEntity<Object> updateServicePrice(@PathVariable("id") Long id, @RequestBody Object body);

    @GetMapping("/cupos")
    ResponseEntity<Object> getCupos(@RequestParam(value = "disponible", required = false) Boolean disponible);

    @PostMapping("/cupos")
    ResponseEntity<Object> createCupo(@RequestBody Object cupo);

    @GetMapping("/boxes")
    ResponseEntity<Object> getBoxes();

    @PostMapping("/boxes")
    ResponseEntity<Object> createBox(@RequestBody Object box);
}