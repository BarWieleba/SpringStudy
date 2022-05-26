package eb.study.springstudy.mappers;

import eb.study.springstudy.dto.AddressDto;
import eb.study.springstudy.entity.Address;
import eb.study.springstudy.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AddressMapper {
    private Address address;

    public AddressMapper(AddressDto dto) {

    }
}
