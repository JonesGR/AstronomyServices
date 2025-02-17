package org.example.laby4AUI_astType.astType.controller.api;

import org.example.laby4AUI_astType.astType.dto.GetAstTypeResponse;
import org.example.laby4AUI_astType.astType.dto.GetAstTypesResponse;
import org.example.laby4AUI_astType.astType.dto.PutAstTypeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface AstTypeController {


    //return list of astronomical object types
    @GetMapping("api/ast_types")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAstTypesResponse getAstTypes();

    //return single astronomical object type
    @GetMapping("api/ast_types/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAstTypeResponse getAstType(
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

    //delete selected astronomical object type
    @DeleteMapping("api/ast_types/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAstType(
      @PathVariable("id")
      UUID id
    );

}
