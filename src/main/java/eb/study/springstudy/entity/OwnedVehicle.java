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

}
