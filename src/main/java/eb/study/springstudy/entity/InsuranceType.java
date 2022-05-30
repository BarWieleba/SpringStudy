package eb.study.springstudy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class InsuranceType {
    @Id
    private Long id;
    private String type;
    private String cost;
}
