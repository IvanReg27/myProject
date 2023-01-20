package com.vkatit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

    @JsonProperty("firstname")
    private String firstName;
    private Long id;
    @JsonProperty("address")
    private String address;
    @JsonProperty("country")
    private String country;
}