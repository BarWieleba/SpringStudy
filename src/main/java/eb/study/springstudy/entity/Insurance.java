package eb.study.springstudy.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Insurance {
    @Id
    private Long id;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private OwnedVehicle fkOwnedVehicle;
    private Date startDate;
    private Date expiration;
    @ManyToOne
    private InsuranceType fkType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OwnedVehicle getFkOwnedVehicle() {
        return fkOwnedVehicle;
    }

    public void setFkOwnedVehicle(OwnedVehicle vehicle) {
        this.fkOwnedVehicle = vehicle;
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
