package org.example.laby4AUI_celestialBody.celestialBody.controller.api;

import org.example.laby4AUI_celestialBody.celestialBody.dto.GetCelestialBodiesResponse;
import org.example.laby4AUI_celestialBody.celestialBody.dto.GetCelestialBodyResponse;
import org.example.laby4AUI_celestialBody.celestialBody.dto.PutCelestialBodyRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface CelestialBodyController {

    //return celestial bodies
    @GetMapping("api/celestial_bodies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCelestialBodiesResponse getCelestialBodies();

 //return celestial bodies belonging to given astronomical object type
    @GetMapping("/api/ast_types/{ast_typeId}/celestial_bodies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCelestialBodiesResponse getAstTypeCelesialBodies(
            @PathVariable("ast_typeId")
            UUID professionId
    );


    @GetMapping("/api/celestial_bodies/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCelestialBodyResponse getCelestialBody(
            @PathVariable("id")
            UUID id
    );


    @PutMapping("/api/celestial_bodies/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putCelestialBody(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutCelestialBodyRequest request
    );

    @DeleteMapping("/api/celestial_bodies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCelestialBody(
            @PathVariable("id")
            UUID id
    );


}
