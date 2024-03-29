package eb.study.springstudy.services;

import eb.study.springstudy.dto.OwnedVehicleDto;
import eb.study.springstudy.entity.OwnedVehicle;
import eb.study.springstudy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnedVehicleService {
    @Autowired
    OwnedVehicleRepository ownedVehicleRepository;

    @Autowired
    OwnedVehicleRepository ownedVehicleJoinRepository;

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

    @Transactional
    public void updateOwnedVehicle(OwnedVehicleDto dto) {
        ownedVehicleRepository.updateOwnedVehicleById(dto.getFkColourId(), dto.getFkBodyStyleId(), dto.getId());
    }

    @Transactional
    public void updateOwnedVehicless(Long colourId, Long bodyStyleId, Long greaterThan, Long lesserThan) {
        ownedVehicleRepository.updateOwnedVehiclesByIds(colourId, bodyStyleId, greaterThan, lesserThan);
    }

    @Transactional
    public void deleteOwnedVehicle(OwnedVehicleDto dto) {
        ownedVehicleRepository.deleteById(dto.getId());
    }

    @Transactional
    public void deleteAllOwnedVehicles() {
        ownedVehicleRepository.deleteAll();
    }

    private OwnedVehicle mapper(OwnedVehicleDto dto) {
        OwnedVehicle ownedVehicle = new OwnedVehicle();
        ownedVehicle.setId(dto.getId());
        ownedVehicle.setProductionDate(dto.getProductionDate());
        ownedVehicle.setFkVehicle(vehicleRepository.findById(dto.getFkVehicleId()).get());
        ownedVehicle.setFkBodyStyle(bodyStyleRepository.findById(dto.getFkBodyStyleId()).get());
        ownedVehicle.setFkOwner(ownerRepository.findById(dto.getFkOwnerId()).get());
        ownedVehicle.setFkColour(colourRepository.findById(dto.getFkColourId()).get());
        return ownedVehicle;
    }

    public List<OwnedVehicleResponse> selectWithJoin(){
        return ownedVehicleJoinRepository.selectWithJoin();
    }
}
