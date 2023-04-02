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
                .filter(citizens -> citizens.getCountry() == "Russia")
                .collect(Collectors.toList());
    }

    public List<Citizen> tenCitizensMaxId(Long id) {
        return citizenList.stream()
                .filter(citizens -> citizens.getId() > 990)
                .collect(Collectors.toList());
    }

    //пока не получилось реализовать через заданный диапазон (от ... до ...)
    public List<Citizen> allCitizensRangeDate(String birthDate) {
        return citizenList.stream()
                .filter(citizens -> citizens.getBirthDate().equals("1990"))
                .filter(citizens -> citizens.getBirthDate().equals("1991"))
                .filter(citizens -> citizens.getBirthDate().equals("1992"))
                .filter(citizens -> citizens.getBirthDate().equals("1993"))
                .filter(citizens -> citizens.getBirthDate().equals("1994"))
                .filter(citizens -> citizens.getBirthDate().equals("1995"))
                .filter(citizens -> citizens.getBirthDate().equals("1996"))
                .filter(citizens -> citizens.getBirthDate().equals("1997"))
                .filter(citizens -> citizens.getBirthDate().equals("1998"))
                .filter(citizens -> citizens.getBirthDate().equals("1999"))
                .collect(Collectors.toList());
    }

    //не уверен, что правильно
    public List<Citizen> allCountryDoNotRepeat(String country) {
        return citizenList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Citizen> firstCitizensFourChars(String firstName) {
        return citizenList.stream()
                .filter(citizens -> citizens.getFirstName().length() == 9)
                .collect(Collectors.toList());
    }

    //не получилось реализовать т.к. ДР тип String
//    public List<Citizen> averageDateAllCitizens(String birthDate) {
//        return citizenList.stream()
//                .filter(citizens -> citizens.getBirthDate())
//                .mapToInt(Citizen::getBirthDate)
//                .average().getAsDouble();
//    }
    public List<Citizen> mapThatIdForCitizen(Long id) {
        return citizenList.stream()
                .filter(citizens -> citizens.getId() > 990)
                .collect(Collectors.toList());
    }
}