package airportManager;

public class EconomyClass extends Ticket {
    private float ticket_price;
    private int freedrinks_included;
    private String free_meal;

    public EconomyClass(){
        super();
        this.ticket_price = 0;
        this.freedrinks_included = 0;
        this.free_meal = "";
    }

    public EconomyClass(int baggage_count, boolean is_oneway, int seat, String client_Fname, String client_Lname,
                        int flight_id, int ticket_id, float ticket_price, int freedrinks_included, String free_meal) {
        super(baggage_count, is_oneway, seat, client_Fname, client_Lname, flight_id, ticket_id);
        this.ticket_price = ticket_price;
        this.freedrinks_included = freedrinks_included;
        this.free_meal = free_meal;
    }

    @Override
    public String toString() {
        return "EconomyClass{" +
                "baggage_count=" + baggage_count +
                ", is_oneway=" + is_oneway +
                ", seat=" + seat +
                ", client_Fname='" + client_Fname + '\'' +
                ", client_Lname='" + client_Lname + '\'' +
                ", flight_id=" + flight_id +
                ", ticket_id=" + ticket_id +
                ", ticket_price=" + ticket_price +
                ", freedrinks_included=" + freedrinks_included +
                ", free_meal='" + free_meal + '\'' +
                '}';
    }

    public float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(float ticket_price) {
        this.ticket_price = ticket_price;
    }

    public int getFreedrinks_included() {
        return freedrinks_included;
    }

    public void setFreedrinks_included(int freedrinks_included) {
        this.freedrinks_included = freedrinks_included;
    }

    public String getFree_meal() {
        return free_meal;
    }

    public void setFree_meal(String free_meal) {
        this.free_meal = free_meal;
    }
}
