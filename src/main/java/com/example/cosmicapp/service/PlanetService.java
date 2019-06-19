package com.example.cosmicapp.service;

import com.example.cosmicapp.commons.Mapper;
import com.example.cosmicapp.mappers.PlanetMapper;
import com.example.cosmicapp.models.Planet;
import com.example.cosmicapp.models.dtos.PlanetDTO;
import com.example.cosmicapp.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    private PlanetMapper planetMapper;

    public PlanetService(PlanetRepository planetRepository, PlanetMapper planetMapper) {
        this.planetRepository = planetRepository;
        this.planetMapper = planetMapper;
    }

   /*
    DAO - Data Access Object
     */

    public List<Planet> getPlanets(){
        return this.planetRepository.findAll();
    }

     /*
    DTO - Data Transfer Object
     */

    public List<PlanetDTO> getPlanetsDTO(){
        return this.planetRepository
                .findAll()
                .stream()
                .map(planetMapper::map)
                .collect(Collectors.toList());
    }

    public Planet addPlanet(PlanetDTO planetDTO){
        return planetRepository.save(planetMapper.reverseMap(planetDTO));
    }

    public  void updatePlanet(PlanetDTO planetDTO){
        planetRepository.findPlanetByPlanetName(planetDTO.getPlanetName())
                .ifPresent(planet -> {
                            planet.setDistanceFromSun(planetDTO.getDistanceFromSun());
                            planet.setOneWayLightTimeToTheSun(planetDTO.getOneWayLightTimeToTheSun());
                            planet.setLengthOfYear(planetDTO.getLengthOfYear());
                            planet.setPlanetType(planetDTO.getPlanetType());
                            planet.setPlanetInfo(planet.getPlanetInfo());
                            planet.setPlanetImage(planet.getPlanetImage());
                        planetRepository.save(planet);
                });
    }

    public void deletePlanet (String planteName){
        planetRepository.deletePlanetByPlanetName(planteName);
    }

}
