package eb.study.springstudy.repository;

import eb.study.springstudy.entity.Address;
import eb.study.springstudy.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
