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
    @Query(value = "update insurance set expiration = :expiration, start_date = :start_date where id = :id", nativeQuery = true)
    void updateExpirationAndStartDate(@Param(value = "id") long id, @Param(value = "expiration") Date expiration, @Param(value = "start_date") Date start_date);
}
