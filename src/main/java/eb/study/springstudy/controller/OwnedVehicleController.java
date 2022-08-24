package eb.study.springstudy.controller;

import eb.study.springstudy.dto.OwnedVehicleDto;
import eb.study.springstudy.entity.OwnedVehicle;
import eb.study.springstudy.repository.OwnedVehicleResponse;
import eb.study.springstudy.services.OwnedVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/study/ownedvehicles")
public class OwnedVehicleController {
    @Autowired
    OwnedVehicleService ownedVehicleService;

    @PostMapping("/saveOwnedVehicles")
    public ResponseEntity<List<OwnedVehicle>> saveOwnedVehicles(@RequestBody List<OwnedVehicleDto> ownedVehicleDtos) {
        return ResponseEntity.ok(ownedVehicleService.saveOwnedVehicles(ownedVehicleDtos));
    }

    @PostMapping("/saveOwnedVehicle")
    public ResponseEntity<OwnedVehicle> saveOwnedVehicle(@RequestBody OwnedVehicleDto ownedVehicleDto) {
        return ResponseEntity.ok(ownedVehicleService.saveOwnedVehicle(ownedVehicleDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<OwnedVehicle>> getOwnedVehicles() {
        return ResponseEntity.ok(ownedVehicleService.getOwnedVehicles());
    }

    @GetMapping("/selectWithJoin")
    public ResponseEntity<List<OwnedVehicleResponse>> selectWithJoin(){
        return ResponseEntity.ok(ownedVehicleService.selectWithJoin());
    }

    @PutMapping("/updateOwnedVehicle")
    public ResponseEntity<String> updateOwnedVehicle(@RequestBody OwnedVehicleDto dto) {
        ownedVehicleService.updateOwnedVehicle(dto);
        return ResponseEntity.ok("updated");
    }

    @PostMapping("/updateOwnedVehicles/{colour}/{bodyStyle}/{gt}/{lt}")
    public ResponseEntity<String> updateOwnedVehicles(@PathVariable("colour") Long colour, @PathVariable("bodyStyle") Long bodyStyle, @PathVariable("gt") Long gt, @PathVariable("lt") Long lt) {
        ownedVehicleService.updateOwnedVehicless(colour, bodyStyle, gt, lt);
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/deleteOwnedVehicle")
    public ResponseEntity<String> deleteOwnedVehicle(@RequestBody OwnedVehicleDto dto) {
        ownedVehicleService.deleteOwnedVehicle(dto);
        return ResponseEntity.ok("Deleted Owned Vehicle with Id: " + dto.getId());
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteOwnedVehicles() {
        ownedVehicleService.deleteAllOwnedVehicles();
        return ResponseEntity.ok("Deleted all");
    }
}
