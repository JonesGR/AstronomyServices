package org.example.laby4AUI_astType.astType.initialize;

import org.example.laby4AUI_astType.astType.entity.AstType;
import org.example.laby4AUI_astType.astType.services.AstTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final AstTypeService astTypeService;
    @Autowired
    public InitializeData(AstTypeService astTypeService)
    {
        this.astTypeService = astTypeService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        AstType planets = AstType.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .name("Planets")
                .avgSize(25)
                .build();

        AstType stars = AstType.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .name("Stars")
                .avgSize(50)
                .build();

        AstType moons = AstType.builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .name("Moons")
                .avgSize(50)
                .build();

        astTypeService.saveAstType(planets);
        astTypeService.saveAstType(stars);
        astTypeService.saveAstType(moons);

    }
}
