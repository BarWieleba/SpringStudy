package eb.study.springstudy.controller;

import eb.study.springstudy.dto.OwnerDto;
import eb.study.springstudy.entity.Owner;
import eb.study.springstudy.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("study/owners")
public class OwnersController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/saveOwners")
    public ResponseEntity<List<Owner>> saveOwners(@RequestBody List<OwnerDto> ownerDtos){
        return ResponseEntity.ok(ownerService.saveOwners(ownerDtos));
    }

    @PostMapping("/saveOwner")
    public ResponseEntity<Owner> saveOwner(@RequestBody OwnerDto ownerDto){
        return ResponseEntity.ok(ownerService.saveOwner(ownerDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Owner>> getOwners(){
        return ResponseEntity.ok(ownerService.getOwners());
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        ownerService.deleteAll();
    }
}
