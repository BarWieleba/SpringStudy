package eb.study.springstudy.repository;

import eb.study.springstudy.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    @Modifying
    @Query(value = "update insurance set expiration = :expiration, start_date = :start_date where id >=:id1 and  id <= :id2", nativeQuery = true)
    void updateExpirationAndStartDate( @Param(value = "expiration") Date expiration, @Param(value = "start_date") Date start_date, @Param(value = "id1") Integer id1, @Param(value = "id2") Integer id2);

    @Modifying
    @Query(value = "delete from insurance where id >= :id1 and id<=:id2", nativeQuery = true)
    void deleteInsurances(@Param(value = "id1")Integer id1, @Param(value = "id2")Integer id2);

}
