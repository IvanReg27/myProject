package com.vkatit.controller;

import com.vkatit.model.Citizen;
import com.vkatit.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @GetMapping("/citizens")
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @PostMapping("/citizens")
    public Citizen createNewCitizen(@RequestBody Citizen citizen) {
        citizenService.addNewCitizen(citizen);
        return citizen;
    }

}
