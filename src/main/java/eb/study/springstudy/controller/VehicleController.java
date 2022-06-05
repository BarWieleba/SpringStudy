package eb.study.springstudy.controller;

import eb.study.springstudy.dto.VehicleDto;
import eb.study.springstudy.entity.Vehicle;
import eb.study.springstudy.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/study/vehicles")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping("/saveVehicles")
    public ResponseEntity<List<Vehicle>> saveVehicles(@RequestBody List<VehicleDto> vehicleDtos) {
        return ResponseEntity.ok(vehicleService.saveVehicles(vehicleDtos));
    }

    @PostMapping("/saveVehicle")
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicleDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Vehicle>> getVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        vehicleService.deleteAll();
    }
}
