public class HeatedSeats  implements AddOns {

		double price;
    public HeatedSeats(){
        double price = 789.20;
        this.price = price;
    }

    @Override
    public String getName(){
        return "Heated Seats";
    }
    
    public double getPrice() {
    	return this.price;
    }

}
