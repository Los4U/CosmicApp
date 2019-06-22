package com.example.cosmicapp.controllers;


import com.example.cosmicapp.commons.extras.CreatorXLS;
import com.example.cosmicapp.models.dtos.PlanetDTO;
import com.example.cosmicapp.service.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Controller
public class HomeController {

    private PlanetService planetService;

    public HomeController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String homaPage(Model model){
        model.addAttribute("planets", planetService.getPlanetsDTO());
        return "index";
    }


    @GetMapping("/planets")
    public String planetPage(Model model){
        model.addAttribute("planets", planetService.getPlanetsDTO());
        return "planets";
    }


    @GetMapping("/delete")
    public String deletePlanet(@RequestParam(value = "planet") String planetName){
        planetService.deletePlanet(planetName);
        return "redirect:/planets";
    }

    @PostMapping("/add")
    public String addPlanet(@ModelAttribute PlanetDTO planet){
        planetService.addPlanet(planet);
        return "redirect:/planets";
    }

    @GetMapping("/excel")
    public String createFile() throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        CreatorXLS<PlanetDTO> creatorXLS= new CreatorXLS<>(PlanetDTO.class);
        creatorXLS.createFile(planetService.getPlanetsDTO(), "src/main/", "planets");
        return "redirect:/";
    }




}
