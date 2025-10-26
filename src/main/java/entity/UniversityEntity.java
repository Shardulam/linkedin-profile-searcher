package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "university")
public class UniversityEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<AlumniEntity> alumniEntities;
}