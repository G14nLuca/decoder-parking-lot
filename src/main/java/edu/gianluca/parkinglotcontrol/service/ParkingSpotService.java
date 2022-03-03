package edu.gianluca.parkinglotcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ParkingSpotModel> getAllParkingTickets(Pageable pageable) {
        return spotRepository.findAll(pageable);
    }

    @Transactional
    public void delete(ParkingSpotModel searchResult) {
        spotRepository.delete(searchResult);
    }

}
