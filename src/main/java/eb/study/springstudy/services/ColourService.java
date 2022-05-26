package eb.study.springstudy.services;

import eb.study.springstudy.dto.ColourDto;
import eb.study.springstudy.entity.Colour;
import eb.study.springstudy.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColourService {
    @Autowired
    ColourRepository colourRepository;

    public Colour saveColour(ColourDto dto) {
        Colour colour = mapper(dto);
        return colourRepository.save(colour);
    }

    private Colour mapper(ColourDto dto) {
        Colour colour = new Colour();
        colour.setCarColour(dto.getCarColour());
        return colour;
    }
}
