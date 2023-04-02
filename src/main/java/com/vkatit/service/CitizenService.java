package com.vkatit.service;

import com.vkatit.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitizenService {
    @Autowired
    public CitizenService(List<Citizen> citizenList) {
        this.citizenList = citizenList;
    }
    @Qualifier("citizenList")
    List<Citizen> citizenList;
    public List<Citizen> citizensLivingInThatCountry(String country) {
        return citizenList.stream()
                .filter(citizen -> citizen.getCountry() == "Russia")
                .collect(Collectors.toList());
    }

}