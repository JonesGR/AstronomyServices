package org.example.laby4AUI_celestialBody.celestialBody.function;

import org.example.laby4AUI_celestialBody.celestialBody.dto.GetCelestialBodiesResponse;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CelestialBodiesToResponseFunction implements Function<List<CelestialBody>, GetCelestialBodiesResponse> {
    @Override
    public GetCelestialBodiesResponse apply(List<CelestialBody> entities) {
        return GetCelestialBodiesResponse.builder()
                .celestialBodies(entities.stream()
                        .map(celestialBody -> GetCelestialBodiesResponse.CelestialBody.builder()
                                .id(celestialBody.getId())
                                .name(celestialBody.getName())
                                .build())
                        .toList())
                .build();
    }
}