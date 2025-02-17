package org.example.laby4AUI_celestialBody.celestialBody.controller.impl;

import lombok.extern.java.Log;
import org.example.laby4AUI_celestialBody.celestialBody.controller.api.CelestialBodyController;
import org.example.laby4AUI_celestialBody.celestialBody.dto.GetCelestialBodiesResponse;
import org.example.laby4AUI_celestialBody.celestialBody.dto.GetCelestialBodyResponse;
import org.example.laby4AUI_celestialBody.celestialBody.dto.PutCelestialBodyRequest;
import org.example.laby4AUI_celestialBody.celestialBody.function.CelestialBodiesToResponseFunction;
import org.example.laby4AUI_celestialBody.celestialBody.function.CelestialBodyToResponseFunction;
import org.example.laby4AUI_celestialBody.celestialBody.function.RequestToCelestialBodyFunction;
import org.example.laby4AUI_celestialBody.celestialBody.services.CelestialBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class CelestialBodyDefaultController implements CelestialBodyController {
    private final CelestialBodyService service;
    private final CelestialBodyToResponseFunction celestialBodyToResponse;
    private final CelestialBodiesToResponseFunction celestialBodiesToResponse;
    private final RequestToCelestialBodyFunction requestToCelestialBody;
    @Autowired
    public CelestialBodyDefaultController(
            CelestialBodyService service,
            CelestialBodyToResponseFunction celestialBodyToResponse,
            CelestialBodiesToResponseFunction celestialBodiesToResponse,
            RequestToCelestialBodyFunction requestToCelestialBody
    ) {
        this.service = service;
        this.celestialBodyToResponse = celestialBodyToResponse;
        this.celestialBodiesToResponse = celestialBodiesToResponse;
        this.requestToCelestialBody = requestToCelestialBody;
    }

    @Override
    public GetCelestialBodiesResponse getCelestialBodies() {
        return celestialBodiesToResponse.apply(service.findAllCelestialBodies());
    }

    @Override
    public GetCelestialBodiesResponse getAstTypeCelesialBodies(UUID astTypeID) {
        return service.findAllByAstType(astTypeID)
                .map(celestialBodiesToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public GetCelestialBodyResponse getCelestialBody(UUID id) {
       //return celestialBodyToResponse.apply(service.findAllCelestialBodiesByID(id));
        return service.findAllCelestialBodiesByID(id).map(celestialBodyToResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public void putCelestialBody(UUID id, PutCelestialBodyRequest request) {
        service.saveCelestialBody(requestToCelestialBody.apply(id, request));
    }

    @Override
    public void deleteCelestialBody(UUID id) {
        service.findAllCelestialBodiesByID(id)
                        .ifPresentOrElse(
                                celestialBody -> service.deleteCelestialBodyByID(id),
                                () -> {
                                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                                }
                        );
    }
}
