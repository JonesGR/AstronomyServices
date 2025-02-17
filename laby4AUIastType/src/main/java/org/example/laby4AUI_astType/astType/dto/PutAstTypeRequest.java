package org.example.laby4AUI_astType.astType.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class PutAstTypeRequest {
    private String name;
    private int avgSize;

}
