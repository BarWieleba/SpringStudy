package eb.study.springstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BodyStyleDto {
    private Long id;
    private String style;
    private Integer doorNumber;
}
