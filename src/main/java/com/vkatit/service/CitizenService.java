package com.vkatit.service;

import com.vkatit.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    @Qualifier("citizenList")
    @Autowired
    List<Citizen> citizenList;

    public List<Citizen> getAllCitizens() {
        return citizenList;
    }

    public Citizen getCitizenById(Long id){
        for (Citizen citizen: citizenList){
            if (citizen.getId().equals(id) ){
                return citizen;
            }
        }
        return null;
    }

}
