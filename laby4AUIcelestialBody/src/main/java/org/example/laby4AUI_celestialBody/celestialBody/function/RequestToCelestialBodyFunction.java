package org.example.laby4AUI_celestialBody.celestialBody.function;

import org.example.laby4AUI_celestialBody.astType.entity.AstType;
import org.example.laby4AUI_celestialBody.celestialBody.dto.PutCelestialBodyRequest;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
@Component

public class RequestToCelestialBodyFunction implements BiFunction<UUID, PutCelestialBodyRequest, CelestialBody> {
    @Override
    public CelestialBody apply(UUID id, PutCelestialBodyRequest request) {
        return CelestialBody.builder()
                .id(id)
                .name(request.getName())
                .radius(request.getRadius())
                .astType(AstType.builder()
                        .id(request.getAstType())
                        .build())
                .build();
    }
}
