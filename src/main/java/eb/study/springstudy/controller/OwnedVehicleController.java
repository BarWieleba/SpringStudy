package eb.study.springstudy.controller;

import eb.study.springstudy.dto.OwnedVehicleDto;
import eb.study.springstudy.entity.OwnedVehicle;
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

    @PutMapping("/updateOwnedVehicle")
    public ResponseEntity<OwnedVehicle> updateOwnedVehicle(@RequestBody OwnedVehicleDto dto) {
        return ResponseEntity.ok(ownedVehicleService.updateOwnedVehicle(dto));
    }

    @DeleteMapping("/deleteOwnedVehicle")
    public ResponseEntity<String> deleteOwnedVehicle(@RequestBody OwnedVehicleDto dto) {
        ownedVehicleService.deleteOwnedVehicle(dto);
        return ResponseEntity.ok("Deleted Owned Vehicle with Id: " + dto.getId());
    }
}
