package de.traumastudios.ExoCompanionAPI.growspeed.repository;

import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class GrowspeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public GrowspeedEntity(Growspeed entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
