package eb.study.springstudy.services;

import eb.study.springstudy.dto.InsuranceDto;
import eb.study.springstudy.entity.Insurance;
import eb.study.springstudy.repository.InsuranceRepository;
import eb.study.springstudy.repository.InsuranceTypeRepository;
import eb.study.springstudy.repository.OwnedVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    InsuranceRepository insuranceRepository;

    @Autowired
    InsuranceTypeRepository insuranceTypeRepository;

    @Autowired
    OwnedVehicleRepository ownedVehicleRepository;

    public Insurance saveInsurance(InsuranceDto dto) {
        Insurance insurance = mapper(dto);
        return insuranceRepository.save(insurance);
    }

    public List<Insurance> saveInsurances(List<InsuranceDto> dtos) {
        List<Insurance> insurances = new ArrayList<>();
        for(InsuranceDto dto : dtos) {
            Insurance insurance = mapper(dto);
            insurances.add(insurance);
        }
        return insuranceRepository.saveAll(insurances);
    }

    public List<Insurance> getInsurances() {
        return insuranceRepository.findAll();
    }

    private Insurance mapper(InsuranceDto dto) {
        Insurance insurance = new Insurance();
        insurance.setId(dto.getId());
        insurance.setStartDate(dto.getStartDate());
        insurance.setExpiration(dto.getExpiration());
        insurance.setFkType(insuranceTypeRepository.findById(dto.getFkTypeId()).get());
        insurance.setFkOwnedVehicle(ownedVehicleRepository.findById(dto.getFkOwnedVehicleId()).get());
        return insurance;
    }

    @Transactional
    public void updateInsuranceExpirationAndStartDate(InsuranceDto newInsuranceDto, Integer id1, Integer id2){
        insuranceRepository.updateExpirationAndStartDate(newInsuranceDto.getExpiration(), newInsuranceDto.getStartDate(), id1, id2);
    }

    @Transactional
    public void deleteInsurances(Integer id1, Integer id2){
        insuranceRepository.deleteInsurances(id1, id2);
    }


}
