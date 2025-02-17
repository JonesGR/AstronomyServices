package org.example.laby4AUI_astType.astType.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ast_types")
public class AstType implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "avg_size", nullable = false)
    int avgSize;
}

