package amdocsbootcamp.projectspringapi.repositories;

import amdocsbootcamp.projectspringapi.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
