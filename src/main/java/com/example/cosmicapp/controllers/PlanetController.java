package com.example.cosmicapp.controllers;
import com.example.cosmicapp.models.Planet;
import com.example.cosmicapp.models.dtos.PlanetDTO;
import com.example.cosmicapp.service.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PlanetController {

    private PlanetService planetService;
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planets")
    public List<Planet> getPlanets(){
        return this.planetService.getPlanets();
    }

    /*

    DTO - Data Transfer Object
     */

//    @GetMapping("/dto/planets")
//    public List<PlanetDTO> getPlanetsDTO(){
//        return this.planetService.getPlanetsDTO();
//    }

    @PostMapping("/dto/planets")
    public Planet addPlanet(@RequestBody PlanetDTO planetDTO){
         return planetService.addPlanet(planetDTO);
    }

    @PutMapping("/dto/planets")
    public void updatePlanet(@RequestBody PlanetDTO planetDTO){
        planetService.updatePlanet(planetDTO);
    }

    @DeleteMapping("/dto/planets/{planetName}")
    public void deletePlanet(@PathVariable String planetName){
        planetService.deletePlanet(planetName);
    }

    @GetMapping("/dto/planets")
    public List<PlanetDTO> getPlanetsDTO(@RequestParam (value = "distance", required = false) Long distance){
       if(distance != null && distance > 0){
           return this.planetService.getPlanetByDistanceFromSun(distance);
       }
       return planetService.getPlanetsDTO();

    }



}
