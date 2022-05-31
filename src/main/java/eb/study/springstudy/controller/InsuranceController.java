package eb.study.springstudy.controller;

import eb.study.springstudy.dto.InsuranceDto;
import eb.study.springstudy.entity.Insurance;
import eb.study.springstudy.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PostMapping("/updateInsurance/{id1}/{id2}")
    public void updateInsurance( @RequestBody InsuranceDto newInsuranceDto, @PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2){
        insuranceService.updateInsuranceExpirationAndStartDate(newInsuranceDto, id1, id2);
    }

    @DeleteMapping("/deleteInsurances/{id1}/{id2}")
    public void deleteInsurances(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2){
        insuranceService.deleteInsurances(id1, id2);
    }

    @DeleteMapping("/deleteAllInsurances")
    public void deleteAllInsurances(){
        insuranceService.deleteAllInsurances();
    }
}
