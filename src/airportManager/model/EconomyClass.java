package airportManager.model;

public class EconomyClass extends Ticket {
    private float ticketPrice;
    private int freeDrinksIncluded;
    private String freeMeal;


    public EconomyClass(int baggageCount, boolean isOneway, int seat, String clientFname, String clientLname, int flightId, int ticketId, float ticketPrice, int freeDrinksIncluded, String freeMeal) {
        super(baggageCount, isOneway, seat, clientFname, clientLname, flightId, ticketId);
        this.ticketPrice = ticketPrice;
        this.freeDrinksIncluded = freeDrinksIncluded;
        this.freeMeal = freeMeal;
    }

    @Override
    public String toString() {
        return "EconomyClass{" +
                "baggageCount=" + baggageCount +
                ", isOneway=" + isOneway +
                ", seat=" + seat +
                ", clientFname='" + clientFname + '\'' +
                ", clientLname='" + clientLname + '\'' +
                ", flightId=" + flightId +
                ", ticketId=" + ticketId +
                ", ticketPrice=" + ticketPrice +
                ", freeDrinksIncluded=" + freeDrinksIncluded +
                ", freeMeal='" + freeMeal + '\'' +
                '}';
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getFreeDrinksIncluded() {
        return freeDrinksIncluded;
    }

    public void setFreeDrinksIncluded(int freeDrinksIncluded) {
        this.freeDrinksIncluded = freeDrinksIncluded;
    }

    public String getFreeMeal() {
        return freeMeal;
    }

    public void setFreeMeal(String freeMeal) {
        this.freeMeal = freeMeal;
    }

    public EconomyClass() {
        this.freeMeal = "";
    }
}
