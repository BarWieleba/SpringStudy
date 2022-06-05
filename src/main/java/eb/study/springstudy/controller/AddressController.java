package eb.study.springstudy.controller;

import eb.study.springstudy.dto.AddressDto;
import eb.study.springstudy.entity.Address;
import eb.study.springstudy.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("study/address")
public class AddressController {
    protected final Logger log = Logger.getLogger("AddressController"); //org.apache.log4j.Logger;

    @Autowired
    private AddressService addressService;

    @PostMapping("/saveAdresses")
    public ResponseEntity <List<Address>>saveAddresses(@RequestBody List<AddressDto> addressDto){
        return ResponseEntity.ok(addressService.saveAddresses(addressDto));
    }

    @PostMapping("/saveAdress")
    public ResponseEntity <Address>saveAddress(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.saveAddress(addressDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Address>> getAddresses(){
        return ResponseEntity.ok(addressService.getAddresses());
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        addressService.deleteAll();
    }

}
