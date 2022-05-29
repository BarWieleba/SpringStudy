package eb.study.springstudy.controller;

import eb.study.springstudy.dto.ColourDto;
import eb.study.springstudy.entity.Colour;
import eb.study.springstudy.services.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("study/colour")
public class ColourController {
    @Autowired
    ColourService colourService;

    @PostMapping("/saveColour")
    public ResponseEntity <Colour> saveColour(@RequestBody ColourDto colourDto){
        return ResponseEntity.ok(colourService.saveColour(colourDto));
    }

    @PostMapping("/saveColours")
    public ResponseEntity<List<Colour>> saveColours(@RequestBody List<ColourDto> colourDtoList){
        return ResponseEntity.ok(colourService.saveColours(colourDtoList));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Colour>>getColours(@RequestBody List<ColourDto> colourDtoList){
        return ResponseEntity.ok(colourService.getColours());
    }
}
