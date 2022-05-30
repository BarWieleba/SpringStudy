package eb.study.springstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnedVehicleDto {
    private Long id;
    private Long fkOwnerId;
    private Long fkVehicleId;
    private Date productionDate;
    private Long fkBodyStyleId;
    private Long fkColourId;

}
