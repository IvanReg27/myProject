package com.vkatit.service;

import com.vkatit.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    List<Country> countries;

    public List<Country> getAllCountries() {
        return countries;
    }
}