package eb.study.springstudy.services;

import eb.study.springstudy.dto.BodyStyleDto;
import eb.study.springstudy.entity.BodyStyle;
import eb.study.springstudy.repository.BodyStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodyStyleService {
    @Autowired
    BodyStyleRepository bodyStyleRepository;

    public BodyStyle saveBodyStyle(BodyStyleDto dto) {
        return bodyStyleRepository.save(mapper(dto));
    }

    public List<BodyStyle> saveBodyStyles(List<BodyStyleDto> dtos) {
        List<BodyStyle> bodyStyles = new ArrayList<>();
        for(BodyStyleDto dto : dtos) {
            BodyStyle bodyStyle = mapper(dto);
            bodyStyles.add(bodyStyle);
        }
        return bodyStyleRepository.saveAll(bodyStyles);
    }

    public List<BodyStyle> getBodyStyles() {
        return bodyStyleRepository.findAll();
    }


    private BodyStyle mapper(BodyStyleDto dto) {
        BodyStyle bodyStyle = new BodyStyle();
        bodyStyle.setId(dto.getId());
        bodyStyle.setDoorNumber(dto.getDoorNumber());
        bodyStyle.setStyle(dto.getStyle());
        return bodyStyle;
    }
}
