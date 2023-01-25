package com.vkatit.service;

import com.vkatit.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    List<Citizen> citizens;

    public List<Citizen> getAllCitizens() {
        return citizens;
    }

}
