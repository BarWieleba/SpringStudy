package eb.study.springstudy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OwnedVehicleDto {
    private Long id;
    private Long fkOwnerId;
    private Long fkVehicleId;
    private Date productionDate;
    private Long fkBodyStyleId;
    private Long fkColourId;

}
