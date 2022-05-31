package eb.study.springstudy.repository;

import eb.study.springstudy.entity.OwnedVehicle;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnedVehicleRepository extends JpaRepository<OwnedVehicle, Long> {

    @Modifying
    @Query(value = "update owned_vehicle set fk_colour_id =?1, fk_body_style_id =?2 where id=?3", nativeQuery = true)
    void updateOwnedVehicleById(Long colour, Long bodyStyle, Long id);

    @Modifying
    @Query(value = "update owned_vehicle set fk_colour_id =?1, fk_body_style_id =?2 where id>?3 and id<?4", nativeQuery = true)
    void updateOwnedVehiclesByIds(Long colour, Long bodyStyle, Long greaterThanId, Long lessThanId);
}
