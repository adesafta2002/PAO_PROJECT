package airportManager.model;

import airportManager.utils.StorageHelper;

import java.util.ArrayList;
import java.util.List;

public class Flight implements Comparable<Flight>{
    private int totalSeats;
    private boolean isPrivate;
    private String airportName;
    private float fuelNeeded;
    private int flightId;
    private int crewMembersNumber;
    private String companyName;
    private List<String> crewMembersNames;

    public Flight(){
        this.airportName = "";
        this.flightId = -1;
        this.companyName = "";
        this.crewMembersNames = new ArrayList<String>();
    }

    public Flight(int totalSeats, boolean isPrivate, String airportName, float fuelNeeded, int flightId, int crewMembersNumber, String companyName, List<String> crewMembersNames) {
        this.totalSeats = totalSeats;
        this.isPrivate = isPrivate;
        this.airportName = airportName;
        this.fuelNeeded = fuelNeeded;
        this.flightId = flightId;
        this.crewMembersNumber = crewMembersNumber;
        this.companyName = companyName;
        this.crewMembersNames = crewMembersNames;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "totalSeats=" + totalSeats +
                ", isPrivate=" + isPrivate +
                ", airportName='" + airportName + '\'' +
                ", fuelNeeded=" + fuelNeeded +
                ", flightId=" + flightId +
                ", crewMembersNumber=" + crewMembersNumber +
                ", companyName='" + companyName + '\'' +
                ", crewMembersNames=" + crewMembersNames +
                '}';
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public float getFuelNeeded() {
        return fuelNeeded;
    }

    public void setFuelNeeded(float fuelNeeded) {
        this.fuelNeeded = fuelNeeded;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCrewMembersNumber() {
        return crewMembersNumber;
    }

    public void setCrewMembersNumber(int crewMembersNumber) {
        this.crewMembersNumber = crewMembersNumber;
    }

    public List<String> getCrewMembersNames() {
        return crewMembersNames;
    }

    public void setCrewMembersNames(List<String> crewMembersNames) {
        this.crewMembersNames = crewMembersNames;
    }

    public int compareTo(Flight flight2) {
        int flight2id = flight2.getFlightId();
        return this.flightId - flight2id;
    }
}


