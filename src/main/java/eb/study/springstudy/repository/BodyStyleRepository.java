package eb.study.springstudy.repository;

import eb.study.springstudy.entity.BodyStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyStyleRepository extends JpaRepository<BodyStyle, Long> {
}
