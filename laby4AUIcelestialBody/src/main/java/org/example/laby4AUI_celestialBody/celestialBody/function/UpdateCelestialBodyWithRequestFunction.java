package org.example.laby4AUI_celestialBody.celestialBody.function;

import org.example.laby4AUI_celestialBody.celestialBody.dto.PatchCelestialBodyRequest;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component
public class UpdateCelestialBodyWithRequestFunction implements BiFunction<CelestialBody, PatchCelestialBodyRequest, CelestialBody> {

    @Override
    public CelestialBody apply(CelestialBody entity, PatchCelestialBodyRequest request) {
        return CelestialBody.builder()
                .id(entity.getId())
                .name(entity.getName())
                .radius(entity.getRadius())
                .astType(entity.getAstType())
                .build();
    }
}
