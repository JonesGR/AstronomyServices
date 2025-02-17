package org.example.laby4AUI_celestialBody.astType.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.laby4AUI_celestialBody.celestialBody.entity.CelestialBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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


    @OneToMany(mappedBy = "astType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CelestialBody> celestialBodies;
    public void addCelestialBody(CelestialBody celestialBody) {
        if (celestialBodies == null) {
            celestialBodies = new ArrayList<>();
        }
        celestialBodies.add(celestialBody);
        celestialBody.setAstType(this);
    }

}

