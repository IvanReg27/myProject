package com.vkatit.controller;

import com.vkatit.model.Citizen;
import com.vkatit.service.CitizenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @GetMapping("/citizens")
    public List<Citizen> getAllCitizens() {
        log.info("keke");
        return citizenService.getAllCitizens();
    }

    //add logic
    public Citizen createNewCitizen( Citizen citizen) {
        return null;
    }

}
