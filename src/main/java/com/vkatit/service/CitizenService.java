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

    @Qualifier("citizensData")
    @Autowired
    private Map<Long, Citizen> citizenMap;


    public List<Citizen> getFirst10Citizens() {
        return citizens.subList(0, 10);
    }

    public Citizen getCitizenById(Long citizenId) {
        return citizenMap.get(citizenId);
    }


}
