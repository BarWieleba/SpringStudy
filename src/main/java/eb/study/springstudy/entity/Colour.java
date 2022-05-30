package eb.study.springstudy.entity;

import lombok.Builder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
public class Colour {
    @Id
    private Long id;
    private String carColour;

    @OneToMany
    private Set<OwnedVehicle> ownedVehicles;

    public Colour() {

    }

    public Colour(Long id, String carColour,  Set<OwnedVehicle> ownedVehicles) {
        this.id = id;
        this.carColour = carColour;
        this.ownedVehicles = ownedVehicles;
    }

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
