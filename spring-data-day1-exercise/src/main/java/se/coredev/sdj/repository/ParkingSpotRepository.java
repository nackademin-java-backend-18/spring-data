package se.coredev.sdj.repository;

import org.springframework.data.repository.CrudRepository;
import se.coredev.sdj.repository.data.ParkingSpot;

public interface ParkingSpotRepository extends CrudRepository<ParkingSpot, Long> {
}
