package edu.gianluca.parkinglotcontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.gianluca.parkinglotcontrol.model.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    @Query("SELECT spot FROM ParkingSpotModel spot WHERE spot.parkingTicket = :parkingTicket")
    ParkingSpotModel findTicket(@Param("parkingTicket") String parkingTicket);

}
