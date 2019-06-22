package com.example.cosmicapp.controllers;


import com.example.cosmicapp.models.dtos.PlanetDTO;
import com.example.cosmicapp.service.PlanetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private PlanetService planetService;

    public HomeController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String homaPage(Model model){
        model.addAttribute("planets", planetService.getPlanetsDTO());
        System.out.println("Planet: " + planetService.getPlanetsDTO());
        return "index";
    }


    @GetMapping("/planets")
    public String planetPage(Model model){
        System.out.println("Planety: " + planetService.getPlanetsDTO());
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

}
