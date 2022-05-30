package eb.study.springstudy.services;

import eb.study.springstudy.dto.InsuranceTypeDto;
import eb.study.springstudy.entity.Insurance;
import eb.study.springstudy.entity.InsuranceType;
import eb.study.springstudy.repository.InsuranceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceTypeService {
    @Autowired
    InsuranceTypeRepository insuranceTypeRepository;

    public InsuranceType saveInsurance(InsuranceTypeDto dto) {
        InsuranceType insuranceType = mapper(dto);
        return insuranceTypeRepository.save(insuranceType);
    }

    public List<InsuranceType> saveInsurances(List<InsuranceTypeDto> dtos) {
        List<InsuranceType> insuranceTypes = new ArrayList<>();
        for(InsuranceTypeDto dto : dtos) {
            InsuranceType insuranceType = mapper(dto);
            insuranceTypes.add(insuranceType);
        }
        return insuranceTypeRepository.saveAll(insuranceTypes);
    }

    public List<InsuranceType> getInsurances() {
        return insuranceTypeRepository.findAll();
    }

    private InsuranceType mapper(InsuranceTypeDto dto) {
        InsuranceType insuranceType = new InsuranceType();
        insuranceType.setId(dto.getId());
        insuranceType.setType(dto.getType());
        insuranceType.setCost(dto.getCost());
        return insuranceType;
    }
}
