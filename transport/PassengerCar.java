package transport;

import drivers.Driver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class PassengerCar extends Transport {

    private float engineVolume;

    private final List<Driver<?>> drivers = new ArrayList<>();

    private final List<Mechanic<?>> mechanics = new ArrayList<>();

    private final List<Sponsor> sponsors = new ArrayList<>();

    // private String transmission;
    // private final String bodyType;
    // private String registrationNumber;
    // private int numberOfSeats;

    public PassengerCar(String brand, String model, float engineVolume) {
        super(brand, model);
        if (engineVolume < 0.5) {
            this.engineVolume = 1.5f;
        } else {
            this.engineVolume = engineVolume;}
    }

    public void adDriver(Driver<?>... drivers) {
        this.drivers.addAll(Arrays.asList(drivers));
    }

    public void adMechanic(Mechanic<?>... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }

    public void adSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public List<Driver<?>> getDrivers() {
        return drivers;
    }

    public List<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        if (engineVolume <= 0.5) {
            this.engineVolume = 1.5f;
        } else {
            this.engineVolume = engineVolume;}

    }


    public abstract void startMoving ();

    public abstract void finishMoving ();

    public abstract boolean getDiagnosed ();

    public abstract void repair ();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerCar)) return false;
        if (!super.equals(o)) return false;
        PassengerCar passengerCar = (PassengerCar) o;
        return Float.compare(passengerCar.engineVolume, engineVolume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineVolume);
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "engineVolume=" + engineVolume +
                "} " + super.toString();
    }
}


// public void informationOfTheCar() {
//    System.out.println(getBrand() + " " + getModel() + ", " + getProductionYear() + " год выпуска" + ", сборка - " + getProductionCountry() + ", цвет кузова - " + getColor() + ", объем двигателя - " + getEngineVolume() + " л." +
//       ", коробка передач - " + getTransmission() + ", тип кузова - " + getBodyType() + ", регистрационный номер - " + getRegistrationNumber() + ", количество мест - " + getNumberOfSeats());
// }

// @Override
//public void refill() {
//   System.out.println("Можно заправлять бензином, дизелем на заправке или заряжать на специальных электропарковках, если это электрокар");
//}
