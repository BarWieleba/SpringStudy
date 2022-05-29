package eb.study.springstudy.controller;

import eb.study.springstudy.dto.OwnerDto;
import eb.study.springstudy.entity.Owner;
import eb.study.springstudy.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("study/owners")
public class OwnersCotroller {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/save")
    public ResponseEntity<List<Owner>> saveOwners(@RequestBody List<OwnerDto> ownerDtos){
        return ResponseEntity.ok(ownerService.saveOwners(ownerDtos));
    }

    @PostMapping("/saveOwners")
    public ResponseEntity<Owner> saveOwner(@RequestBody OwnerDto ownerDto){
        return ResponseEntity.ok(ownerService.saveOwner(ownerDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Owner>> getOwners(){
        return ResponseEntity.ok(ownerService.getOwners());
    }
}
