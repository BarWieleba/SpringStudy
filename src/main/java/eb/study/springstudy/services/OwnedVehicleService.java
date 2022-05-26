package eb.study.springstudy.services;

import eb.study.springstudy.dto.OwnedVehicleDto;
import eb.study.springstudy.entity.OwnedVehicle;
import eb.study.springstudy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnedVehicleService {
    @Autowired
    OwnedVehicleRepository ownedVehicleRepository;

    @Autowired
    ColourRepository colourRepository;

    @Autowired
    InsuranceRepository insuranceRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    BodyStyleRepository bodyStyleRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    public OwnedVehicle saveOwnedVehicle(OwnedVehicleDto dto) {
        OwnedVehicle ownedVehicle = mapper(dto);
        return ownedVehicleRepository.save(ownedVehicle);
    }

    public List<OwnedVehicle> saveOwnedVehicles(List<OwnedVehicleDto> dtos) {
        List<OwnedVehicle> ownedVehicles = new ArrayList<>();
        for(OwnedVehicleDto dto : dtos) {
            OwnedVehicle ownedVehicle = mapper(dto);
            ownedVehicles.add(ownedVehicle);
        }
        return ownedVehicleRepository.saveAll(ownedVehicles);
    }

    public List<OwnedVehicle> getOwnedVehicles() {
        return ownedVehicleRepository.findAll();
    }

    private OwnedVehicle mapper(OwnedVehicleDto dto) {
        OwnedVehicle ownedVehicle = new OwnedVehicle();
        ownedVehicle.setProductionDate(dto.getProductionDate());
        ownedVehicle.setFkVehicle(vehicleRepository.getReferenceById(dto.getFkVehicleId()));
        ownedVehicle.setFkBodyStyle(bodyStyleRepository.getReferenceById(dto.getFkBodyStyleId()));
        ownedVehicle.setFkOwner(ownerRepository.getReferenceById(dto.getFkOwnerId()));
        ownedVehicle.setFkColour(colourRepository.getReferenceById(dto.getFkColourId()));
        return ownedVehicle;
    }
}