package org.example.laby4AUI_celestialBody.astType.services;

import org.example.laby4AUI_celestialBody.astType.entity.AstType;
import org.example.laby4AUI_celestialBody.astType.repositories.AstTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AstTypeService {
    private final AstTypeRepository astTypeRepository;
    @Autowired
    public AstTypeService(AstTypeRepository astTypeRepository)
    {
        this.astTypeRepository = astTypeRepository;
    }

    public void saveAstType(AstType astType) {
        astTypeRepository.save(astType);
    }
    public long countAstTypes() {
        return astTypeRepository.count();
    }
    public List<AstType> findAllAstTypes()
    {
        return astTypeRepository.findAll();
    }

    public Optional<AstType> findAllAstTypeByID(UUID id)
    {
        return astTypeRepository.findById(id);
    }

    public void deleteAstType(UUID id)
    {
        astTypeRepository.findById(id).ifPresent(astTypeRepository::delete);
    }


}
