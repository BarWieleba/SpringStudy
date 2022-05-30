package eb.study.springstudy.controller;

import eb.study.springstudy.dto.InsuranceDto;
import eb.study.springstudy.entity.Insurance;
import eb.study.springstudy.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("study/insurance")
public class InsuranceController {
    @Autowired
    InsuranceService insuranceService;

    @PostMapping("/saveInsurances")
    public ResponseEntity<List<Insurance>> saveInsurances(@RequestBody List<InsuranceDto> insuranceDtos) {
        return ResponseEntity.ok(insuranceService.saveInsurances(insuranceDtos));
    }

    @PostMapping("/saveInsurance")
    public ResponseEntity<Insurance> saveInsurance(@RequestBody InsuranceDto insuranceDto) {
        return ResponseEntity.ok(insuranceService.saveInsurance(insuranceDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Insurance>> getInsurances() {
        return ResponseEntity.ok(insuranceService.getInsurances());
    }

    @PostMapping("/updateInsurance")
    public void updateInsurance( @RequestBody InsuranceDto newInsuranceDto){
        insuranceService.updateInsuranceExpirationAndStartDate(newInsuranceDto);
    }
}
