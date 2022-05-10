package airportManager.model;

public class Ticket {
    protected int baggageCount;
    protected boolean isOneway;
    protected int seat;
    protected String clientFname;
    protected String clientLname;
    protected  int flightId;
    protected int ticketId;

    public Ticket() {
        this.clientFname = "";
        this.clientLname = "";
    }


    public Ticket(int baggageCount, boolean isOneway, int seat, String clientFname, String clientLname, int flightId, int ticketId) {
        this.baggageCount = baggageCount;
        this.isOneway = isOneway;
        this.seat = seat;
        this.clientFname = clientFname;
        this.clientLname = clientLname;
        this.flightId = flightId;
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "baggageCount=" + baggageCount +
                ", isOneway=" + isOneway +
                ", seat=" + seat +
                ", clientFname='" + clientFname + '\'' +
                ", clientLname='" + clientLname + '\'' +
                ", flightId=" + flightId +
                ", ticketId=" + ticketId +
                '}';
    }

    public int getBaggageCount() {
        return baggageCount;
    }

    public void setBaggageCount(int baggageCount) {
        this.baggageCount = baggageCount;
    }

    public boolean isOneway() {
        return isOneway;
    }

    public void setOneway(boolean oneway) {
        isOneway = oneway;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getClientFname() {
        return clientFname;
    }

    public void setClientFname(String clientFname) {
        this.clientFname = clientFname;
    }

    public String getClientLname() {
        return clientLname;
    }

    public void setClientLname(String clientLname) {
        this.clientLname = clientLname;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
