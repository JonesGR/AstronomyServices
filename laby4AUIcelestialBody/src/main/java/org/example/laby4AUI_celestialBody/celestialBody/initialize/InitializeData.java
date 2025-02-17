package org.example.laby4AUI_celestialBody.celestialBody.initialize;

import org.example.laby4AUI_celestialBody.astType.entity.AstType;
import org.example.laby4AUI_celestialBody.astType.services.AstTypeService;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;
import org.example.laby4AUI_celestialBody.celestialBody.services.CelestialBodyService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final AstTypeService astTypeService;
    private final CelestialBodyService celestialBodyService;
    @Autowired
    public InitializeData(AstTypeService astTypeService, CelestialBodyService celestialBodyService)
    {
        this.astTypeService = astTypeService;
        this.celestialBodyService = celestialBodyService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        AstType planets = AstType.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .celestialBodies(new ArrayList<>())
                .build();

        AstType stars = AstType.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .celestialBodies(new ArrayList<>())
                .build();

        AstType moons = AstType.builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .celestialBodies(new ArrayList<>())
                .build();



        CelestialBody earth = CelestialBody.builder()
                .id(UUID.fromString("0a36b7d5-c1a5-45a0-8eb5-83c1f3decb3f"))
                .name("Earth")
                .radius(6371)
                .build();

        CelestialBody mars = CelestialBody.builder()
                .id(UUID.randomUUID())
                .name("Mars")
                .radius(3389)
                .build();

        CelestialBody sun = CelestialBody.builder()
                .id(UUID.randomUUID())
                .name("Sun")
                .radius(700000)
                .build();

        CelestialBody deimos = CelestialBody.builder()
                .id(UUID.randomUUID())
                .name("Deimos")
                .radius(6)
                .build();




//        celestialBodyService.saveCelestialBody(earth);
//        celestialBodyService.saveCelestialBody(mars);
//        celestialBodyService.saveCelestialBody(sun);
//        celestialBodyService.saveCelestialBody(deimos);
//
        planets.addCelestialBody(earth);
        planets.addCelestialBody(mars);
        stars.addCelestialBody(sun);
        moons.addCelestialBody(deimos);

        astTypeService.saveAstType(planets);
        astTypeService.saveAstType(stars);
        astTypeService.saveAstType(moons);



    }
}
