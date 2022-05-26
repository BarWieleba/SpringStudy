package eb.study.springstudy.repository;

import eb.study.springstudy.entity.OwnedVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnedVehicleRepository extends JpaRepository<OwnedVehicle, Long> {
}
