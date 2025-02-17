package org.example.laby4AUI_astType.astType.function;

import org.example.laby4AUI_astType.astType.dto.GetAstTypeResponse;
import org.example.laby4AUI_astType.astType.entity.AstType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AstTypeToResponseFunction implements Function<AstType, GetAstTypeResponse> {

    @Override
    public GetAstTypeResponse apply(AstType entity) {
        return GetAstTypeResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .avgSize(entity.getAvgSize())
                .build();
    }
}