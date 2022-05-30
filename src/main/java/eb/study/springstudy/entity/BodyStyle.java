package eb.study.springstudy.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class BodyStyle {
    @Id
    private Long id;
    private String style;
    private Integer doorNumber;

    @OneToMany
    private Set<OwnedVehicle> ownedVehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }
}
