package eb.study.springstudy.services;

import eb.study.springstudy.dto.AddressDto;
import eb.study.springstudy.entity.Address;
import eb.study.springstudy.repository.AddressRepository;
import eb.study.springstudy.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OwnerRepository ownerRepository;

    public Address saveAddress(AddressDto dto) {
        return addressRepository.save(mapper(dto));
    }

    public List<Address> saveAddresses(List<AddressDto> dtos) {
        List<Address> addresses = new ArrayList<>();
        for(AddressDto dto : dtos) {
            Address address = mapper(dto);
            addresses.add(address);
        }
        return addressRepository.saveAll(addresses);
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    private Address mapper(AddressDto dto) {
        Address address = new Address();
        address.setPostalCode(dto.getPostalCode());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());
        address.setApartmentNumber(dto.getApartmentNumber());
        address.setFkOwner(ownerRepository.getReferenceById(dto.getFkOwnerId()));
        return address;
    }
}
