package edu.gianluca.parkinglotcontrol.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ParkingSpotDTO {

    @NotBlank
    private String spotSector;

    @NotNull
    private int spotNumber;

    @NotBlank
    private String parkingTicket;

    @NotBlank
    private String entranceDateTime;

    @NotBlank
    private String exitDateTime;

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

    @Override
    public String toString() {
        return "Parking Ticket Received - sector:" + spotSector + " number: " + spotNumber + " ticket: " + parkingTicket
                + " entrance: " + entranceDateTime + " exit: " + exitDateTime;
    }

}
