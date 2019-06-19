package com.example.cosmicapp.repository;


import com.example.cosmicapp.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    //Optional<Planet> findPlanetByPlanetName();

    //NATIVE QUERY
//    @Query(value = "select * from planets where planet_name  = ?1", nativeQuery = true)//JPQL
//    Optional<Planet> findPlanetByPlanetName(String planetName);

    @Query("select p from Planet planet where planet.planetName  = ?1") //JPQL
    Optional<Planet> findPlanetByPlanetName(String planetName);

    @Modifying
    @Transactional
    @Query("select p from Planet planet where planet.planetName  = ?1")
    void deletePlanetByPlanetName(String planetName);


}
