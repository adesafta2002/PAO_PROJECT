package airportManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flight implements Comparable<Flight>{
    private int total_seats;
    private boolean is_private;
    private String airport_name;
    private float fuel_needed;
    private int flight_id;
    private int crew_members_number;
    private String company_name;
    private List<String> crew_members_names;

    public Flight(){
        this.total_seats = 0;
        this.is_private = false;
        this.airport_name = "";
        this.fuel_needed = 0;
        this.flight_id = -1;
        this.crew_members_number = 0;
        this.company_name = "";
        this.crew_members_names = new ArrayList<String>();
    }
    public Flight(int total_seats, boolean is_private, String airport_name, float fuel_needed, int flight_id,
                  int crew_members_number, String company_name, List<String> crew_members_names) {
        this.total_seats = total_seats;
        this.is_private = is_private;
        this.airport_name = airport_name;
        this.fuel_needed = fuel_needed;
        this.flight_id = flight_id;
        this.crew_members_number = crew_members_number;
        this.company_name = company_name;
        this.crew_members_names = crew_members_names;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "total_seats=" + total_seats +
                ", is_private=" + is_private +
                ", airport_name='" + airport_name + '\'' +
                ", fuel_needed=" + fuel_needed +
                ", flight_id=" + flight_id +
                ", crew_members_number=" + crew_members_number +
                ", company_name='" + company_name + '\'' +
                ", crew_members_names=" + crew_members_names +
                '}';
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public boolean isIs_private() {
        return is_private;
    }

    public void setIs_private(boolean is_private) {
        this.is_private = is_private;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public float getFuel_needed() {
        return fuel_needed;
    }

    public void setFuel_needed(float fuel_needed) {
        this.fuel_needed = fuel_needed;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getCrew_members_number() {
        return crew_members_number;
    }

    public void setCrew_members_number(int crew_members_number) {
        this.crew_members_number = crew_members_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public List<String> getCrew_members_names() {
        return crew_members_names;
    }

    public void setCrew_members_names(List<String> crew_members_names) {
        this.crew_members_names = crew_members_names;
    }

    public int compareTo(Flight flight2) {
        int flight2id = flight2.getFlight_id();
        return this.flight_id - flight2id;
    }
}


