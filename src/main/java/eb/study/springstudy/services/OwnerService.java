package eb.study.springstudy.services;

import eb.study.springstudy.dto.OwnerDto;
import eb.study.springstudy.entity.Owner;
import eb.study.springstudy.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    public Owner saveOwner(OwnerDto ownerDto){
        Owner owner = mapper(ownerDto);
        return ownerRepository.save(owner);
    }

    public List<Owner> saveOwners(List<OwnerDto> ownerDtos) {
        List<Owner> owners = new ArrayList<>();
        for(OwnerDto ownerDto : ownerDtos) {
            Owner owner = mapper(ownerDto);
            owners.add(owner);
        }
        return ownerRepository.saveAll(owners);
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    private Owner mapper(OwnerDto dto) {
        Owner owner = new Owner();
        owner.setName(dto.getName());
        owner.setSurname(dto.getSurname());
        owner.setBirthdate(dto.getBirthdate());
        owner.setPesel(dto.getPesel());
        return owner;
    }
}
