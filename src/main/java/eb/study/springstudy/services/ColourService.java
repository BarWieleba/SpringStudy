package eb.study.springstudy.services;

import eb.study.springstudy.dto.ColourDto;
import eb.study.springstudy.entity.Colour;
import eb.study.springstudy.repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        colour.setId(dto.getId());
        colour.setCarColour(dto.getCarColour());
        return colour;
    }

    public List<Colour> saveColours(List<ColourDto> dtos){
        List<Colour> colours = new ArrayList<>();
        for(ColourDto colourDto : dtos){
            colours.add(mapper(colourDto));
        }
        return colourRepository.saveAll(colours);
    }

    public List<Colour> getColours(){
        return colourRepository.findAll();
    }
}
