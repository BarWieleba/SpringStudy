package eb.study.springstudy.repository;

import eb.study.springstudy.entity.OwnedVehicle;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnedVehicleRepository extends JpaRepository<OwnedVehicle, Long> {

    @Modifying
    @Query(value = "update owned_vehicle set fk_colour_id =?1, fk_body_style_id =?2 where id=?3", nativeQuery = true)
    void updateOwnedVehicleById(Long colour, Long bodyStyle, Long id);

    @Modifying
    @Query(value = "update owned_vehicle set fk_colour_id =?1, fk_body_style_id =?2 where id>?3 and id<?4", nativeQuery = true)
    void updateOwnedVehiclesByIds(Long colour, Long bodyStyle, Long greaterThanId, Long lessThanId);

    @Query(value = "select v.brand as brand, v.model as model, i.start_date as startDate, i.expiration as expiration, bs.door_number as doorNumber, bs.style as style, a.city as city, a.street as street, a.apartment_number as apartmentNumber, a.house_number as houseNumber, c.car_colour as carColour " +
            "from owned_vehicle " +
            "full outer join vehicle v on v.id = owned_vehicle.fk_vehicle_id " +
            "full outer join insurance i on owned_vehicle.id = i.fk_owned_vehicle_id " +
            "full outer join body_style bs on bs.id = owned_vehicle.fk_body_style_id " +
            "full outer join address a on owned_vehicle.fk_owner_id = a.fk_owner_id " +
            "full outer join colour c on c.id = owned_vehicle.fk_colour_id", nativeQuery = true)
    List<OwnedVehicleResponse> selectWithJoin1();

    @Query(value = "select " +
            "v.brand, " +
            "v.model, " +
            "i.start_date, " +
            "i.expiration, " +
            "bs.door_number, " +
            "bs.style, " +
            "a.city, " +
            "a.street, " +
            "a.apartment_number, " +
            "a.house_number, " +
            "c.car_colour " +
            "from owned_vehicle " +
            "full outer join vehicle v on v.id = owned_vehicle.fk_vehicle_id " +
            "full outer join insurance i on owned_vehicle.id = i.fk_owned_vehicle_id " +
            "full outer join body_style bs on bs.id = owned_vehicle.fk_body_style_id " +
            "full outer join address a on owned_vehicle.fk_owner_id = a.fk_owner_id " +
            "full outer join colour c on c.id = owned_vehicle.fk_colour_id", nativeQuery = true)
    List<OwnedVehicleResponse> selectWithJoin();

}
