package amdocsbootcamp.projectspringapi.services;

import amdocsbootcamp.projectspringapi.dto.mapper.VehicleMapper;
import amdocsbootcamp.projectspringapi.dto.request.MessageResponseDTO;
import amdocsbootcamp.projectspringapi.dto.response.VehicleDTO;
import amdocsbootcamp.projectspringapi.entities.Vehicle;
import amdocsbootcamp.projectspringapi.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper = VehicleMapper.INSTANCE;


    public MessageResponseDTO create(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleMapper.toModel(vehicleDTO);
        Vehicle registeredVehicle = vehicleRepository.save(vehicle);

        return MessageResponseDTO.builder().message("Vehicle successfully registered with plate " + registeredVehicle.getPlate()).build();
    }

    public List<VehicleDTO> listAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehicleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VehicleDTO findById(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return vehicleMapper.toDTO(vehicle);
    }

    public void delete(Integer id) {
        vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicleRepository.deleteById(id);
    }
}
