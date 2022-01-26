package amdocsbootcamp.projectspringapi.dto.mapper;

import amdocsbootcamp.projectspringapi.dto.response.VehicleDTO;
import amdocsbootcamp.projectspringapi.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    Vehicle toModel(VehicleDTO vehicleDTO);

    VehicleDTO toDTO(Vehicle vehicle);
}
