package eb.study.springstudy.mongo.repository;

import eb.study.springstudy.mongo.entity.Colour;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColourRepository extends MongoRepository<Colour, String> {
}
