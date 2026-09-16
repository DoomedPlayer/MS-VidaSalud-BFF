package com.BinarySeint.vsBFF.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "report-svc", url = "http://report-svc:8080/api/report")
public interface ReportClient {
    @GetMapping("/kpis/today")
    ResponseEntity<Object> getKpisToday();

    @GetMapping("/top-services")
    ResponseEntity<Object> getTopServices(@RequestParam(value = "range", required = false) String range);
}