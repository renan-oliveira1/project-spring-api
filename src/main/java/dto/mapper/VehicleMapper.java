package dto.mapper;

import dto.resquest.VehicleDTO;
import entities.Vehicle;
import org.mapstruct.Mapper;

@Mapper
public interface VehicleMapper {

    Vehicle toModel(VehicleDTO vehicleDTO);

    VehicleDTO toDTO(Vehicle vehicle);
}
