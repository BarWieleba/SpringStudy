package eb.study.springstudy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OwnerDto {
    private Long id;
    private String name;
    private String surname;
    private Date birthdate;
    private Long pesel;
}
