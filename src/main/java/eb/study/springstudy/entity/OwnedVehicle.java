package eb.study.springstudy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OwnedVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Owner fkOwner;
    @ManyToOne
    private Vehicle fkVehicle;
    private Date productionDate;
    @ManyToOne
    private BodyStyle fkBodyStyle;
    @ManyToOne
    private Colour fkColour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getFkOwner() {
        return fkOwner;
    }

    public void setFkOwner(Owner fkOwner) {
        this.fkOwner = fkOwner;
    }

    public Vehicle getFkVehicle() {
        return fkVehicle;
    }

    public void setFkVehicle(Vehicle fkVehicle) {
        this.fkVehicle = fkVehicle;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public BodyStyle getFkBodyStyle() {
        return fkBodyStyle;
    }

    public void setFkBodyStyle(BodyStyle fkBodyStyle) {
        this.fkBodyStyle = fkBodyStyle;
    }

    public Colour getFkColour() {
        return fkColour;
    }

    public void setFkColour(Colour fkColour) {
        this.fkColour = fkColour;
    }
}
