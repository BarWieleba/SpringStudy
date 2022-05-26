package eb.study.springstudy.services;

import eb.study.springstudy.dto.VehicleDto;
import eb.study.springstudy.entity.Vehicle;
import eb.study.springstudy.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(VehicleDto dto) {
        Vehicle vehicle = mapper(dto);
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> saveVehicles(List<VehicleDto> dtos) {
        List<Vehicle> vehicles = new ArrayList<>();
        for(VehicleDto dto : dtos) {
            Vehicle vehicle = mapper(dto);
            vehicles.add(vehicle);
        }
        return vehicleRepository.saveAll(vehicles);
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }
    private Vehicle mapper(VehicleDto dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        return vehicle;
    }
}
