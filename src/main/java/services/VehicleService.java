package services;

import dto.mapper.VehicleMapper;
import dto.response.MessageResponseDTO;
import dto.resquest.VehicleDTO;
import entities.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.VehicleRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;


    public MessageResponseDTO create(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleMapper.toModel(vehicleDTO);
        Vehicle registeredVehicle = vehicleRepository.save(vehicle);

        return MessageResponseDTO.builder().message("Vehicle successfully registered with plate " + registeredVehicle.getPlate()).build();
    }
}
