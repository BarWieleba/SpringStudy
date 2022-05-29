package eb.study.springstudy.controller;

import eb.study.springstudy.dto.BodyStyleDto;
import eb.study.springstudy.entity.BodyStyle;
import eb.study.springstudy.services.BodyStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/study/bodystyle")
public class BodyStyleController {
    @Autowired
    BodyStyleService bodyStyleService;

    @PostMapping("/saveBodyStyles")
    public ResponseEntity<List<BodyStyle>> saveBodyStyles(List<BodyStyleDto> bodyStyleDtos) {
        return ResponseEntity.ok(bodyStyleService.saveBodyStyles(bodyStyleDtos));
    }

    @PostMapping("/saveBodyStyle")
    public ResponseEntity<BodyStyle> saveBodyStyle(BodyStyleDto bodyStyleDto) {
        return ResponseEntity.ok(bodyStyleService.saveBodyStyle(bodyStyleDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<BodyStyle>> getBodyStyles() {
        return ResponseEntity.ok(bodyStyleService.getBodyStyles());
    }
}
