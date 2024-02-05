package de.traumastudios.ExoCompanionAPI.growspeed.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureEntity;
import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany(mappedBy = "growSpeeds")
    @JsonBackReference
    private List<CultureEntity> cultures;

    public GrowspeedEntity(Growspeed entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.cultures = entity.getCultures().stream().map(CultureEntity::new).toList();
    }
}
