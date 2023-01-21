package com.vkatit.controller;

import com.vkatit.model.Country;
import com.vkatit.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CountriesController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCounties() {
        return countryService.getAllCountries();
    }


}
