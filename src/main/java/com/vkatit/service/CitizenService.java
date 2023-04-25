package com.vkatit.service;

import com.vkatit.exception.CitizenNotFound;
import com.vkatit.model.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
                .filter(citizens -> citizens.getCountry().equals(country))
                .collect(Collectors.toList());
    }
    public List<Citizen> tenCitizensMaxId(Long id) {
        return citizenList.stream()
                .sorted(Comparator.comparing(Citizen::getId))
                .limit(10)
                .collect(Collectors.toList());
    }
    public List<String> allCountryDoNotRepeat() {
        return citizenList.stream()
                .map(Citizen::getCountry)
                .distinct()
                .collect(Collectors.toList());
    }
    public Citizen firstCitizensFourChars(Integer length) {
        return citizenList.stream()
                .filter(s -> s.getFirstName().length() == length)
                .findFirst().orElseThrow(CitizenNotFound::new);
    }
    public Map<Long, Citizen> mapIdCitizenForAllValue() {
        return citizenList.stream()
                .collect(Collectors.toMap(Citizen::getId, Function.identity()));
    }
    public Map<String, List<Citizen>> mapCountryForCitizens() {
        return citizenList.stream()
                .collect(Collectors.groupingBy(Citizen::getCountry));
    }
}