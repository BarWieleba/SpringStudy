package eb.study.springstudy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String postalCode;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer apartmentNumber;
    @ManyToOne(cascade = CascadeType.DETACH)
    private Owner fkOwner;
}
