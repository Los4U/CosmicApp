package com.example.cosmicapp.controllers;


import com.example.cosmicapp.commons.extras.CreatorXLS;
import com.example.cosmicapp.models.dtos.PlanetDTO;
import com.example.cosmicapp.service.PlanetService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
        SecurityContext securityContext = SecurityContextHolder.getContext() ;
        model.addAttribute("message", "You are logged as: " + securityContext.getAuthentication().getName());
        return "index";
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }



}
