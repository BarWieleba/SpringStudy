package eb.study.springstudy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class InsuranceDto {
    private Long id;
    private Long fkVehicleId;
    private Date startDate;
    private Date expiration;
    private Long fkTypeId;
}
