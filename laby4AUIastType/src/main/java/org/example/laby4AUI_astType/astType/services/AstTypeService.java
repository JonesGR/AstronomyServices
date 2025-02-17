package org.example.laby4AUI_astType.astType.services;

import org.example.laby4AUI_astType.astType.entity.AstType;
import org.example.laby4AUI_astType.astType.event.repository.api.AstTypeEventRepository;
import org.example.laby4AUI_astType.astType.repositories.AstTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AstTypeService {
    private final AstTypeRepository astTypeRepository;
    private final AstTypeEventRepository eventRepository;
    @Autowired
    public AstTypeService(AstTypeRepository astTypeRepository, AstTypeEventRepository eventRepository)
    {
        this.astTypeRepository = astTypeRepository;
        this.eventRepository = eventRepository;
    }

    public void saveAstType(AstType astType) {
        astTypeRepository.save(astType);
        eventRepository.create(astType);
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
        eventRepository.delete(id);
    }


}
