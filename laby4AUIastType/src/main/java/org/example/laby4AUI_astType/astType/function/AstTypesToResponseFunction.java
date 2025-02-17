package org.example.laby4AUI_astType.astType.function;

import org.example.laby4AUI_astType.astType.dto.GetAstTypesResponse;
import org.example.laby4AUI_astType.astType.entity.AstType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class AstTypesToResponseFunction implements Function<List<AstType>, GetAstTypesResponse> {
    @Override
    public GetAstTypesResponse apply(List<AstType> entities) {
        return GetAstTypesResponse.builder()
                .astTypes(entities.stream()
                        .map(astType -> GetAstTypesResponse.AstType.builder()
                                .id(astType.getId())
                                .name(astType.getName())
                                .build())
                        .toList())
                .build();
    }
}
