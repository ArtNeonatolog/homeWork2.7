package transport;

import java.util.LinkedList;
import java.util.Queue;

public class TechStation {

    private final Queue<PassengerCar> queue = new LinkedList<>();

    private void addAuto (PassengerCar passengerCar) {
       queue.offer(passengerCar);
    }
    public void addA (Car car) {
        addAuto(car);
    }
    public void addTruck (Truck truck) {
        addAuto(truck);
    }
    public void doDiagnostic () {
        if (!queue.isEmpty()) {
        PassengerCar passengerCar = queue.poll();
        boolean result = passengerCar.getDiagnosed();
        if(!result) {
            passengerCar.repair();
        }

        }
    }

}
