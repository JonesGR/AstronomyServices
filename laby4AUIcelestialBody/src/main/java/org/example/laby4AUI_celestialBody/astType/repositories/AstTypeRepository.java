package org.example.laby4AUI_celestialBody.astType.repositories;

import org.example.laby4AUI_celestialBody.astType.entity.AstType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AstTypeRepository extends JpaRepository<AstType, UUID> {

}
