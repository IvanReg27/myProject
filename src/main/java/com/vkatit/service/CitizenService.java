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
import java.util.stream.Stream;

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

    //пока не получилось реализовать через заданный диапазон (от ... до ...)

//    public List<Citizen> allCitizensRangeDate(LocalDateTime birthDate) {
//        return citizenList.stream()
//                .filter(citizens -> citizens.getBirthDate().equals("1990"))
//                .filter(citizens -> citizens.getBirthDate().equals("1991"))
//                .filter(citizens -> citizens.getBirthDate().equals("1992"))
//                .filter(citizens -> citizens.getBirthDate().equals("1993"))
//                .filter(citizens -> citizens.getBirthDate().equals("1994"))
//                .filter(citizens -> citizens.getBirthDate().equals("1995"))
//                .filter(citizens -> citizens.getBirthDate().equals("1996"))
//                .filter(citizens -> citizens.getBirthDate().equals("1997"))
//                .filter(citizens -> citizens.getBirthDate().equals("1998"))
//                .filter(citizens -> citizens.getBirthDate().equals("1999"))
//                .collect(Collectors.toList());
//    }

    public List<Citizen> allCountryDoNotRepeat(String country) {
        return citizenList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Citizen firstCitizensFourChars(Integer length) {
        return citizenList.stream()
                .filter(s -> s.getFirstName().length() == length)
                .findFirst().orElseThrow(CitizenNotFound::new);
    }

    //не получилось реализовать т.к. ДР тип String (конвертировать надо...но есть символы "-" и ".")

//    public List<Citizen> averageDateAllCitizens(LocalDateTime birthDate) {
//        return citizenList.stream()
//                .filter(citizens -> citizens.getBirthDate())
//                .mapToInt(Citizen::getBirthDate)
//                .average().getAsDouble();
//    }
    public Map<Long, Citizen> mapIdCitizenForAllValue() {
        return citizenList.stream()
                .collect(Collectors.toMap(Citizen::getId, Function.identity()));
    }
    public Map<String, List<Citizen>> mapCountryForCitizens() {
        return citizenList.stream()
                .collect(Collectors.groupingBy(Citizen::getCountry));
    }

    //не уверен, что правильно (split?)
//    public List<String> splitStringIntoWords() {
//        return words.stream()
//            .flatMap(pair -> Stream.of(pair.split("\\s")))
//            .collect(Collectors.toList());
//    }
}