package org.example.laby4AUI_astType.astType.event.repository.api;

import org.example.laby4AUI_astType.astType.entity.AstType;

import java.util.UUID;

public interface AstTypeEventRepository {
    /**
     * Delete profession.
     *
     * @param id profession's id
     */
    void delete(UUID id);

    void create(AstType ast_type);
}
