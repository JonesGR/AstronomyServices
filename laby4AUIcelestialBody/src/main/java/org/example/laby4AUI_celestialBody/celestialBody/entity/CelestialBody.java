package org.example.laby4AUI_celestialBody.celestialBody.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import org.example.laby4AUI_celestialBody.astType.entity.AstType;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name="celestial_bodies")
public class CelestialBody implements Serializable, Comparable<CelestialBody> {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "radius", nullable = false)
    int radius;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ast_type_id", nullable = false)
    AstType astType;

    @Override
    public int compareTo(CelestialBody other) {
        return this.name.compareTo(other.name);
    }

}
