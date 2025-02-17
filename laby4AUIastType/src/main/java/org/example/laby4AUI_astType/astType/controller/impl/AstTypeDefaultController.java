package org.example.laby4AUI_astType.astType.controller.impl;

import lombok.extern.java.Log;
import org.example.laby4AUI_astType.astType.controller.api.AstTypeController;
import org.example.laby4AUI_astType.astType.dto.GetAstTypeResponse;
import org.example.laby4AUI_astType.astType.dto.GetAstTypesResponse;
import org.example.laby4AUI_astType.astType.dto.PutAstTypeRequest;
import org.example.laby4AUI_astType.astType.function.AstTypeToResponseFunction;
import org.example.laby4AUI_astType.astType.function.AstTypesToResponseFunction;
import org.example.laby4AUI_astType.astType.function.RequestToAstTypeFunction;
import org.example.laby4AUI_astType.astType.services.AstTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class AstTypeDefaultController implements AstTypeController {
    private final AstTypeService service;
    private final AstTypeToResponseFunction astTypeToResponse;
    private final AstTypesToResponseFunction astTypesToResponse;
    private final RequestToAstTypeFunction requestToAstTypeFunction;

    @Autowired
    public AstTypeDefaultController(
            AstTypeService service,
            AstTypeToResponseFunction astTypeToResponse,
            AstTypesToResponseFunction astTypesToResponse,
            RequestToAstTypeFunction requestToAstTypeFunction
    ) {
        this.service=service;
        this.astTypeToResponse=astTypeToResponse;
        this.astTypesToResponse=astTypesToResponse;
        this.requestToAstTypeFunction=requestToAstTypeFunction;
    }

    @Override
    public GetAstTypesResponse getAstTypes() {
        return astTypesToResponse.apply(service.findAllAstTypes());
    }

    @Override
    public GetAstTypeResponse getAstType(UUID id) {
        return service.findAllAstTypeByID(id).map(astTypeToResponse).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putAstType(UUID id, PutAstTypeRequest request) {
        service.saveAstType(requestToAstTypeFunction.apply(id, request));
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
}
