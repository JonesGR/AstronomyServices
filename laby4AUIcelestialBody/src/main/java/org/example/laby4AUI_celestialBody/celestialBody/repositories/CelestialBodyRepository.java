package org.example.laby4AUI_celestialBody.celestialBody.repositories;

import org.example.laby4AUI_celestialBody.astType.entity.AstType;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CelestialBodyRepository extends JpaRepository<CelestialBody, UUID> {

    @Query("SELECT c FROM CelestialBody c JOIN FETCH c.astType")
    List<CelestialBody> findCBs();

    List<CelestialBody> findAllByAstType(AstType astType);

}
