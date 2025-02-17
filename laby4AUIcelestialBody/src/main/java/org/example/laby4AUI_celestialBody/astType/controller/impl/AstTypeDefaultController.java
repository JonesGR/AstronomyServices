package org.example.laby4AUI_celestialBody.astType.controller.impl;

import lombok.extern.java.Log;
import org.example.laby4AUI_celestialBody.astType.controller.api.AstTypeController;
import org.example.laby4AUI_celestialBody.astType.dto.PutAstTypeRequest;
import org.example.laby4AUI_celestialBody.astType.function.RequestToAstTypeFunction;
import org.example.laby4AUI_celestialBody.astType.services.AstTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class AstTypeDefaultController implements AstTypeController {
    private final AstTypeService service;
    private final RequestToAstTypeFunction requestToAstTypeFunction;

    @Autowired
    public AstTypeDefaultController(
            AstTypeService service,
            RequestToAstTypeFunction requestToAstTypeFunction
    ) {
        this.service=service;
        this.requestToAstTypeFunction=requestToAstTypeFunction;
    }

    @Override
    public void deleteAstType(UUID id) {
        service.findAllAstTypeByID(id)
                .ifPresentOrElse(astType -> service.deleteAstType(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                        );
    }

    @Override
    public void putAstType(UUID id, PutAstTypeRequest request) {
        service.saveAstType(requestToAstTypeFunction.apply(id, request));
    }
}
