package com.vkatit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vkatit.model.Citizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestInstance(PER_CLASS)

public class DemoApplicationTests {

    @LocalServerPort
    private int randomPort;
    private RestTemplate restTemplate;
    @BeforeEach
    public void init() {
        restTemplate = new RestTemplate();
    }
    @Test
    @DisplayName("Citizens living in a given country")
    public void countryAndCitizens() {
        String nameCountry = "Guatemala";
        Citizen fromGuatemala = Citizen.builder()
                .firstName("Joseph")
                .id(98L)
                .address("Sundown Street")
                .country("Guatemala")
                .birthDate(LocalDateTime.of(1971, 6, 16, 16, 52))
                .build();
        Citizen[] citizens = restTemplate.getForObject("http://localhost:" + randomPort + "/api/citizen/country/" + nameCountry, Citizen[].class);


        assertNotNull(citizens);
        assertEquals(citizens[0], fromGuatemala);
        assertEquals(citizens.length, 1);
    }

    @Test
    @DisplayName("All countries where citizen live (no repetitions(Distinct))")
    public void countriesDistinct() {
        String[] actualCountries = {"Belize", "The Gambia", "Guinea", "Venezuela", "China", "Norway", "Lithuania",
                "Ireland", "Thailand", "Poland", "Libya", "Burkina Faso", "Chile", "Slovakia", "Nicaragua",
                "Serbia", "Slovenia", "Kosovo", "Suriname", "Cameroon", "Dominican Republic", "Cabo Verde",
                "Egypt", "Saint Lucia", "Lesotho", "Sierra Leone", "Lebanon", "Monaco", "El Salvador",
                "Portugal", "Saint Kitts and Nevis", "Korea, South", "Ukraine", "Micronesia", "Liechtenstein",
                "Belarus", "Mauritania", "Spain", "Turkmenistan", "Italy", "Congo, Republic of the", "Estonia",
                "Cyprus", "Zambia", "Eritrea", "Samoa", "East Timor (Timor-Leste)", "United Arab Emirates", "Panama",
                "Honduras", "Swaziland", "Oman", "Papua New Guinea", "Syria", "Sudan", "Montenegro", "Sudan, South",
                "Qatar", "Equatorial Guinea", "Saint Vincent and the Grenadines", "Switzerland", "Turkey", "Ecuador",
                "Netherlands", "Myanmar", "Madagascar", "Andorra", "Uzbekistan", "Azerbaijan", "Tonga", "Mexico",
                "Belgium", "Singapore", "Kiribati", "Chad", "Mozambique", "India", "USA", "Morocco", "Guatemala", "Bangladesh"};
        String[] countries = restTemplate.getForObject("http://localhost:" + randomPort + "/api/citizen/allCountriesDIST", String[].class);
        assertArrayEquals(countries, actualCountries);
    }

    @Test
    @DisplayName("Map that contains the id and value for citizen")
    public void map() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Citizen fromGuatemala = Citizen.builder()
                .firstName("Joseph")
                .id(98L)
                .address("Sundown Street")
                .country("Guatemala")
                .birthDate(LocalDateTime.of(1971, 6, 16, 16, 52))
                .build();

        String easyString = restTemplate.getForObject("http://localhost:" + randomPort + "/api/citizen/map", String.class);
        Map<Long, Citizen> userData = mapper.readValue(
                easyString, new TypeReference<>() {});

        assertEquals(userData.size(), 100);
        assertEquals(userData.get(98L), fromGuatemala);
    }
}