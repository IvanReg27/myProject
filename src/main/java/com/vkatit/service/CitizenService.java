package com.vkatit.service;

import com.vkatit.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class CitizenService {
    @Autowired
    List<Citizen> citizens;

    public void addNewCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

//    @Qualifier("citizensData")
//    @Autowired
//    private Map<Long, Citizen> citizenMap;

    public List<Citizen> getAllCitizens() {
        return citizens;
    }
}