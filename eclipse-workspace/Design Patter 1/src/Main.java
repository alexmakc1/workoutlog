/**
 * Project for a client running a car dealership. Allows customers to build the car of their dreams.
 *As it stands, once customers build their car, they have to come into the lot to hand off their
 * build list. The client is okay with this, but it could probably be more efficient.
 *
 * @author Jacob Labrec
 */

public class Main {
    public static void main(String[] args) {

        //jake wants to buy a truck
        Customer jake = new Customer("Jake","8675309");
        Truck jakesTruck = new Truck(Truck.Make.Tesla,Truck.Model.CyberTruck,jake);
        jakesTruck.addAddon(addonFactory.getAddon("heatedseats"));
        jakesTruck.addAddon(addonFactory.getAddon("fuzzydice"));
        jakesTruck.addAddon(addonFactory.getAddon("sunroof"));
        //jake is satisfied and ready to purchase
        jakesTruck.printTicket();

        //Julie wants a new car
        Customer Julie = new Customer("Julie","5555555");
        Car juliesCar = new Car(Car.Make.Nissan,Car.Model.Altima,Julie);
        //Julie doesn't want any addons and is ready for purchase
        juliesCar.printTicket();



        //David is just shopping for prices
        Customer david = new Customer("David","3141592653");
        Car davidsCar = new Car(Car.Make.Ford,Car.Model.Mustang,david);
        davidsCar.addAddon(addonFactory.getAddon("hydraulics"));
        davidsCar.addAddon(addonFactory.getAddon("fuzzydice"));
        davidsCar.addAddon(new SpinnerRims());

        Truck davidsTruck = new Truck(Truck.Make.Ford, Truck.Model.F150,david);
        davidsTruck.addAddon(addonFactory.getAddon("hydraulics"));
        davidsTruck.addAddon(addonFactory.getAddon("fuzzydice"));
        davidsTruck.addAddon(addonFactory.getAddon("spinnerrims"));

        davidsCar.printTicket();
        davidsTruck.printTicket();





    }
}
