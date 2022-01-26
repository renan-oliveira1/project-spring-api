package amdocsbootcamp.projectspringapi.controllers;

import amdocsbootcamp.projectspringapi.dto.request.MessageResponseDTO;
import amdocsbootcamp.projectspringapi.dto.response.VehicleDTO;
import amdocsbootcamp.projectspringapi.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/vehicle")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageResponseDTO create(@RequestBody @Valid VehicleDTO vehicleDTO){
        return vehicleService.create(vehicleDTO);
    }

    @GetMapping
   public List<VehicleDTO> listAll(){return vehicleService.listAll();}

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehicleDTO findById(@PathVariable @Valid VehicleDTO vehicleDTO){
        return vehicleService.findById(vehicleDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        vehicleService.delete(id);
    }
}
