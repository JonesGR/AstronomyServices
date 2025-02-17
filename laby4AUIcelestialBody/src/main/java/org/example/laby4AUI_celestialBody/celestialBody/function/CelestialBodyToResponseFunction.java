package org.example.laby4AUI_celestialBody.celestialBody.function;

import org.example.laby4AUI_celestialBody.celestialBody.dto.GetCelestialBodyResponse;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class CelestialBodyToResponseFunction implements Function<CelestialBody, GetCelestialBodyResponse> {
    @Override
    public GetCelestialBodyResponse apply(CelestialBody entity) {
        return GetCelestialBodyResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .radius(entity.getRadius())
                .astType(GetCelestialBodyResponse.AstType.builder()
                        .id(entity.getAstType().getId())
                        .build())
                .build();
    }
}
