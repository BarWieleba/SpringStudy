package eb.study.springstudy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Colour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String carColour;

    @OneToMany
    private Set<OwnedVehicle> ownedVehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String colour) {
        this.carColour = colour;
    }
}
