package edu.gianluca.parkinglotcontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gianluca.parkinglotcontrol.dto.ParkingSpotDTO;
import edu.gianluca.parkinglotcontrol.model.ParkingSpotModel;
import edu.gianluca.parkinglotcontrol.service.ParkingSpotService;

@RestController
@RequestMapping("/parking-lot")
@CrossOrigin(origins = " * ", maxAge = 3600)
public class ParkingSpotController {

    @Autowired
    final ParkingSpotService spotService;

    public ParkingSpotController(ParkingSpotService spotService) {
        this.spotService = spotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO spotDTO) {

        if (spotService.existsByTicket(spotDTO.getParkingTicket())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This ticket is already registrated.");
        }

        ParkingSpotModel spotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(spotDTO, spotModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(spotService.save(spotModel));
    }

    @GetMapping("/ticket/{parkingTicket}")
    public ResponseEntity<Object> findTicket(@PathVariable(value = "parkingTicket") String parkingTicket) {
        ParkingSpotModel searchResult = spotService.findTicket(parkingTicket);

        if (searchResult != null) {
            return ResponseEntity.status(HttpStatus.OK).body(searchResult);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Ticket not found.");
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ParkingSpotModel>> getAllTickets(
            @PageableDefault(page = 0, size = 10, sort = "parkingTicket", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(spotService.getAllParkingTickets(pageable));
    }

    @DeleteMapping("/ticket/{parkingTicket}/delete")
    public ResponseEntity<Object> deleteTicket(@PathVariable(value = "parkingTicket") String parkingTicket) {
        ParkingSpotModel searchResult = spotService.findTicket(parkingTicket);

        if (searchResult != null) {
            spotService.delete(searchResult);
            return ResponseEntity.status(HttpStatus.OK).body("Parking Ticket deleted successfully.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Ticket not found.");
    }

    @PutMapping("/ticket/{parkingTicket}/update")
    public ResponseEntity<Object> deleteTicket(@PathVariable(value = "parkingTicket") String parkingTicket,
            @RequestBody @Valid ParkingSpotDTO spotDTO) {
        ParkingSpotModel searchResult = spotService.findTicket(parkingTicket);

        if (searchResult != null) {
            searchResult.setEntranceDateTime(spotDTO.getEntranceDateTime());
            searchResult.setExitDateTime(spotDTO.getExitDateTime());
            searchResult.setSpotNumber(spotDTO.getSpotNumber());
            searchResult.setSpotSector(spotDTO.getSpotSector());

            return ResponseEntity.status(HttpStatus.OK).body(searchResult);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Ticket not found.");
    }

}
