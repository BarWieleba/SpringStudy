package eb.study.springstudy.controller;

import eb.study.springstudy.dto.AddressDto;
import eb.study.springstudy.entity.Address;
import eb.study.springstudy.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("study/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity saveAddresses(@RequestBody List<AddressDto> addressDto){
        try {
            addressService.saveAddresses(addressDto);
            return ResponseEntity.ok("Dodano do bazy: " + addressDto);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/get")
    public ResponseEntity<List<Address>> getAddresses(){
        return ResponseEntity.ok(addressService.getAddresses());
    }

}
