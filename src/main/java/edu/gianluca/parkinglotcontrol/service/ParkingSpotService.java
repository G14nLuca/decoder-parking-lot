package edu.gianluca.parkinglotcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.gianluca.parkinglotcontrol.model.ParkingSpotModel;
import edu.gianluca.parkinglotcontrol.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository spotRepository;

    public ParkingSpotService(ParkingSpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Transactional
    public Object save(ParkingSpotModel spotModel) {
        return spotRepository.save(spotModel);
    }

    public boolean existsByTicket(String parkingTicket) {
        if (findTicket(parkingTicket) != null) {
            return true;
        }
        return false;
    }

    public ParkingSpotModel findTicket(String parkingTicket) {
        return spotRepository.findTicket(parkingTicket);
    }

    public List<ParkingSpotModel> getAllParkingTickets() {
        return spotRepository.findAll();
    }

    @Transactional
    public void delete(ParkingSpotModel searchResult) {
        spotRepository.delete(searchResult);
    }

}
