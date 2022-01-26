package controller;

import dto.response.MessageResponseDTO;
import dto.resquest.VehicleDTO;
import entities.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.VehicleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageResponseDTO create(@RequestBody @Valid VehicleDTO vehicleDTO){
        return vehicleService.create(vehicleDTO);
    }

    @GetMapping
    public List<VehicleDTO> listAll(){return vehicleService.listAll();}
}
