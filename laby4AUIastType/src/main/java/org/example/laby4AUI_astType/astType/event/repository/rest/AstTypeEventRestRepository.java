package org.example.laby4AUI_astType.astType.event.repository.rest;

import org.example.laby4AUI_astType.astType.dto.PutAstTypeRequest;
import org.example.laby4AUI_astType.astType.entity.AstType;
import org.example.laby4AUI_astType.astType.event.repository.api.AstTypeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
@Repository
public class AstTypeEventRestRepository implements AstTypeEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public AstTypeEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/ast_types/{id}", id);
    }

    @Override
    public void create(AstType ast_type) {
        PutAstTypeRequest request = PutAstTypeRequest.builder()
                .build();

        restTemplate.put("/api/ast_types/{id}", request, ast_type.getId());
    }
}

