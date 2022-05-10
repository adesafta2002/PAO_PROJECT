package airportManager.model;

public class FirstClass extends Ticket{
    private float ticketPrice;
    private int showerNumber;
    private String sectionStewardess;

    public FirstClass() {
        this.sectionStewardess = "";
    }

    public FirstClass(int baggageCount, boolean isOneway, int seat, String clientFname, String clientLname, int flightId, int ticketId, float ticketPrice, int showerNumber, String sectionStewardess) {
        super(baggageCount, isOneway, seat, clientFname, clientLname, flightId, ticketId);
        this.ticketPrice = ticketPrice;
        this.showerNumber = showerNumber;
        this.sectionStewardess = sectionStewardess;
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "baggageCount=" + baggageCount +
                ", isOneway=" + isOneway +
                ", seat=" + seat +
                ", clientFname='" + clientFname + '\'' +
                ", clientLname='" + clientLname + '\'' +
                ", flightId=" + flightId +
                ", ticketId=" + ticketId +
                ", ticketPrice=" + ticketPrice +
                ", showerNumber=" + showerNumber +
                ", sectionStewardess='" + sectionStewardess + '\'' +
                '}';
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getShowerNumber() {
        return showerNumber;
    }

    public void setShowerNumber(int showerNumber) {
        this.showerNumber = showerNumber;
    }

    public String getSectionStewardess() {
        return sectionStewardess;
    }

    public void setSectionStewardess(String sectionStewardess) {
        this.sectionStewardess = sectionStewardess;
    }
}
