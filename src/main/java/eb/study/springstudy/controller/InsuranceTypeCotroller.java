package eb.study.springstudy.controller;

import eb.study.springstudy.dto.InsuranceTypeDto;
import eb.study.springstudy.entity.InsuranceType;
import eb.study.springstudy.services.InsuranceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("study/insurancetype")
public class InsuranceTypeCotroller {
    @Autowired
    InsuranceTypeService insuranceTypeService;

    @PostMapping("/saveInsurances")
    public ResponseEntity<List<InsuranceType>> saveInsurances(@RequestBody List<InsuranceTypeDto> insuranceTypeDtos){
        return ResponseEntity.ok(insuranceTypeService.saveInsurances(insuranceTypeDtos));
    }

    @PostMapping("/saveInsurance")
    public ResponseEntity<InsuranceType> saveInsurance(@RequestBody InsuranceTypeDto insuranceTypeDto){
        return ResponseEntity.ok(insuranceTypeService.saveInsurance(insuranceTypeDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<InsuranceType>> getInsurances(){
        return ResponseEntity.ok(insuranceTypeService.getInsurances());
    }
}
