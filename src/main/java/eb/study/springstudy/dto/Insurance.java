package eb.study.springstudy.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
public class Insurance {
    private Long id;
    private Long fkVehicleId;
    private Date startDate;
    private Date expiration;
    private Long fkTypeId;
}
