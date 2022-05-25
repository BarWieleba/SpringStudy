package eb.study.springstudy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private OwnedVehicle vehicle;
    private Date startDate;
    private Date expiration;
    @ManyToOne
    private InsuranceType fkType;
    @OneToMany
    private Set<OwnedVehicle> ownedVehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OwnedVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(OwnedVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public InsuranceType getFkType() {
        return fkType;
    }

    public void setFkType(InsuranceType fkType) {
        this.fkType = fkType;
    }
}
