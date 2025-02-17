package org.example.laby4AUI_celestialBody.celestialBody.services;

import org.example.laby4AUI_celestialBody.astType.repositories.AstTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;
import org.example.laby4AUI_celestialBody.celestialBody.repositories.CelestialBodyRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CelestialBodyService {
    private final CelestialBodyRepository celestialBodyRepository;
    private final AstTypeRepository astTypeRepository;

    @Autowired
    public CelestialBodyService(CelestialBodyRepository celestialBodyRepository, AstTypeRepository astTypeRepository)
    {
        this.celestialBodyRepository = celestialBodyRepository;
        this.astTypeRepository = astTypeRepository;
    }
    public void saveCelestialBody(CelestialBody celestialBody) {
        celestialBodyRepository.save(celestialBody);
    }

    public void deleteCelestialBody(CelestialBody celestialBody)
    {
        celestialBodyRepository.delete(celestialBody);
    }
    public void deleteCelestialBodyByID(UUID id)
    {
        celestialBodyRepository.findById(id).ifPresent(celestialBodyRepository::delete);
    }

    public List<CelestialBody> findAllCelestialBodies()
    {
        return celestialBodyRepository.findAll();
    }
    public Optional<CelestialBody> findAllCelestialBodiesByID(UUID id)
    {
        return celestialBodyRepository.findById(id);
    }
    public List<CelestialBody> findCBs()
    {
        return celestialBodyRepository.findCBs();
    }


    public Optional<List<CelestialBody>> findAllByAstType(UUID astTypeId) {
        return astTypeRepository.findById(astTypeId)
                .map(celestialBodyRepository::findAllByAstType);
    }


}
