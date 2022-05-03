package airportManager;

public class Ticket {
    protected int baggage_count;
    protected boolean is_oneway;
    protected int seat;
    protected String client_Fname;
    protected String client_Lname;
    protected  int flight_id;
    protected int ticket_id;

    public Ticket() {
        this.baggage_count = 0;
        this.is_oneway = false;
        this.seat = 0;
        this.client_Fname = "";
        this.client_Lname = "";
        this.flight_id = 0;
        this.ticket_id = -1;
    }

    public Ticket(int baggage_count, boolean is_oneway, int seat, String client_Fname, String client_Lname, int flight_id, int ticket_id) {
        this.baggage_count = baggage_count;
        this.is_oneway = is_oneway;
        this.seat = seat;
        this.client_Fname = client_Fname;
        this.client_Lname = client_Lname;
        this.flight_id = flight_id;
        this.ticket_id = ticket_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "baggage_count=" + baggage_count +
                ", is_oneway=" + is_oneway +
                ", seat=" + seat +
                ", client_Fname='" + client_Fname + '\'' +
                ", client_Lname='" + client_Lname + '\'' +
                ", flight_id=" + flight_id +
                ", ticket_id=" + ticket_id +
                '}';
    }

    public int getBaggage_count() {
        return baggage_count;
    }

    public void setBaggage_count(int baggage_count) {
        this.baggage_count = baggage_count;
    }

    public boolean isIs_oneway() {
        return is_oneway;
    }

    public void setIs_oneway(boolean is_oneway) {
        this.is_oneway = is_oneway;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getClient_Fname() {
        return client_Fname;
    }

    public void setClient_Fname(String client_Fname) {
        this.client_Fname = client_Fname;
    }

    public String getClient_Lname() {
        return client_Lname;
    }

    public void setClient_Lname(String client_Lname) {
        this.client_Lname = client_Lname;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }
}
