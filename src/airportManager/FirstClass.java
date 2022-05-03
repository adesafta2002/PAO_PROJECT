package airportManager;

public class FirstClass extends Ticket{
    private float ticket_price;
    private int shower_number;
    private String section_stewardess;

    public FirstClass() {
        super();
        this.ticket_price = 0;
        this.shower_number = 0;
        this.section_stewardess = "";
    }

    public FirstClass(int baggage_count, boolean is_oneway, int seat, String client_Fname, String client_Lname, int flight_id, int ticket_id, float ticket_price, int shower_number, String section_stewardess) {
        super(baggage_count, is_oneway, seat, client_Fname, client_Lname, flight_id, ticket_id);
        this.ticket_price = ticket_price;
        this.shower_number = shower_number;
        this.section_stewardess = section_stewardess;
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "baggage_count=" + baggage_count +
                ", is_oneway=" + is_oneway +
                ", seat=" + seat +
                ", client_Fname='" + client_Fname + '\'' +
                ", client_Lname='" + client_Lname + '\'' +
                ", flight_id=" + flight_id +
                ", ticket_id=" + ticket_id +
                ", ticket_price=" + ticket_price +
                ", shower_number=" + shower_number +
                ", section_stewardess='" + section_stewardess + '\'' +
                '}';
    }

    public float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(float ticket_price) {
        this.ticket_price = ticket_price;
    }

    public int getShower_number() {
        return shower_number;
    }

    public void setShower_number(int shower_number) {
        this.shower_number = shower_number;
    }

    public String getSection_stewardess() {
        return section_stewardess;
    }

    public void setSection_stewardess(String section_stewardess) {
        this.section_stewardess = section_stewardess;
    }
}
