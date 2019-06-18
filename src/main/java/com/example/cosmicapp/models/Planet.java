package com.example.cosmicapp.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "planets")
public class Planet {

    private Long id;
    private String planetName;
    private long distanceFromSun;
    private double oneWayLightTimeToTheSun;
    private long lenghtOfYear;
    private String planetType;



}
