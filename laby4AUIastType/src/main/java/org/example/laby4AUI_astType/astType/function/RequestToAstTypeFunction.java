package org.example.laby4AUI_astType.astType.function;

import org.example.laby4AUI_astType.astType.dto.PutAstTypeRequest;
import org.example.laby4AUI_astType.astType.entity.AstType;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToAstTypeFunction implements BiFunction<UUID, PutAstTypeRequest, AstType> {
    @Override
    public AstType apply(UUID uuid, PutAstTypeRequest putAstTypeRequest) {
        return AstType.builder()
                .id(uuid)
                .name(putAstTypeRequest.getName())
                .avgSize(putAstTypeRequest.getAvgSize())
                .build();
    }
}
