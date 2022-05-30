package eb.study.springstudy.dto;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String postalCode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
    private Long fkOwnerId;
}
