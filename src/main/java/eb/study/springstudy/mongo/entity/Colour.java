package eb.study.springstudy.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("Colour")
public class Colour {
    @Id
    private String id;
    private String carColour;

    public Colour(String id, String carColour) {
        this.id = id;
        this.carColour = carColour;
    }
}
