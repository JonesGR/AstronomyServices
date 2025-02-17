package org.example.laby4AUI_celestialBody.astType.controller.api;


import org.example.laby4AUI_celestialBody.astType.dto.PutAstTypeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface AstTypeController {

    @DeleteMapping("api/ast_types/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAstType(
      @PathVariable("id")
      UUID id
    );

    @PutMapping("/api/ast_types/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putAstType(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutAstTypeRequest request
    );

}
