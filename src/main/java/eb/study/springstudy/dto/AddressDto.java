package eb.study.springstudy.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
public class AddressDto {
    private Long id;
    private String postalCode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
    private Long fkOwnerId;
}
