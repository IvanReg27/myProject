package com.vkatit.controller;

import com.vkatit.model.Citizen;
import com.vkatit.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/citizen")

public class CitizenController {
    private final CitizenService service;

    @GetMapping("/country/{name}")
    public ResponseEntity<List<Citizen>> citizensLivingInThatCountry(@PathVariable String name) {
        return ResponseEntity.ok(service.citizensLivingInThatCountry(name));
    }

    @GetMapping("/allCountriesDIST")
    public ResponseEntity<List<String>> allCountryDoNotRepeat() {
        return ResponseEntity.ok(service.allCountryDoNotRepeat());
    }

    @GetMapping("/map")
    public ResponseEntity<Map<Long, Citizen>> mapIdCitizenForAllValue() {
        return ResponseEntity.ok(service.mapIdCitizenForAllValue());
    }
}