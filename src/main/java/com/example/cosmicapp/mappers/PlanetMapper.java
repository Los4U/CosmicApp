package com.example.cosmicapp.mappers;

import com.example.cosmicapp.commons.Mapper;
import com.example.cosmicapp.models.Planet;
import com.example.cosmicapp.models.dtos.PlanetDTO;
import org.springframework.stereotype.Component;

@Component
public class PlanetMapper implements Mapper<Planet, PlanetDTO> {

    @Override
    public PlanetDTO map(Planet planetFrom) {
        return PlanetDTO
                .builder()
                .planetName(planetFrom.getPlanetName())
                .distanceFromSun(planetFrom.getDistanceFromSun())
                .oneWayLightTimeToTheSun(planetFrom.getOneWayLightTimeToTheSun())
                .lengthOfYear(planetFrom.getLengthOfYear())
                .planetType(planetFrom.getPlanetType())
                .planetInfo(planetFrom.getPlanetInfo())
                .planetImage(planetFrom.getPlanetImage())
                .build();
    }

    @Override
    public Planet reverseMap(PlanetDTO planetTo) {
        return Planet
                .builder()
                .planetName(planetTo.getPlanetName())
                .distanceFromSun(planetTo.getDistanceFromSun())
                .oneWayLightTimeToTheSun(planetTo.getOneWayLightTimeToTheSun())
                .lengthOfYear(planetTo.getLengthOfYear())
                .planetType(planetTo.getPlanetType())
                .planetInfo(planetTo.getPlanetInfo())
                .planetImage(planetTo.getPlanetImage())
                .build();
    }
}
