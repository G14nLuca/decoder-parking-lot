package edu.gianluca.parkinglotcontrol.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARKING_SPOT")
public class ParkingSpotModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String spotSector;

    @Column(nullable = false)
    private int spotNumber;

    @Column(nullable = false, length = 10)
    private String parkingTicket;

    @Column(nullable = false)
    private String entranceDateTime;

    @Column(nullable = false)
    private String exitDateTime;

    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return int return the spotNumber
     */
    public int getSpotNumber() {
        return spotNumber;
    }

    /**
     * @param spotNumber the spotNumber to set
     */
    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    /**
     * @return String return the parkingTicket
     */
    public String getParkingTicket() {
        return parkingTicket;
    }

    /**
     * @param parkingTicket the parkingTicket to set
     */
    public void setParkingTicket(String parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    /**
     * @return String return the entranceDateTime
     */
    public String getEntranceDateTime() {
        return entranceDateTime;
    }

    /**
     * @param entranceDateTime the entranceDateTime to set
     */
    public void setEntranceDateTime(String entranceDateTime) {
        this.entranceDateTime = entranceDateTime;
    }

    /**
     * @return String return the exitDateTime
     */
    public String getExitDateTime() {
        return exitDateTime;
    }

    /**
     * @param exitDateTime the exitDateTime to set
     */
    public void setExitDateTime(String exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    /**
     * @return String return the spotSector
     */
    public String getSpotSector() {
        return spotSector;
    }

    /**
     * @param spotSector the spotSector to set
     */
    public void setSpotSector(String spotSector) {
        this.spotSector = spotSector;
    }

}
