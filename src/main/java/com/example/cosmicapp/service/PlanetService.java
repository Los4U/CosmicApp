package com.example.cosmicapp.service;

import com.example.cosmicapp.models.Planet;
import com.example.cosmicapp.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> getPlanets(){
        return this.planetRepository.findAll();
    }



}
