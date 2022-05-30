package eb.study.springstudy.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Insurance {
    @Id
    private Long id;
    @ManyToOne
    private OwnedVehicle fkVehicle;
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

    public OwnedVehicle getFkVehicle() {
        return fkVehicle;
    }

    public void setFkVehicle(OwnedVehicle vehicle) {
        this.fkVehicle = vehicle;
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
