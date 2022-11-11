package transport;

import transport.PassengerCar;

import java.util.Objects;

public class Mechanic <P extends PassengerCar> {
    private final String nameAndSurname;

    private final String company;


    public Mechanic(String nameAndSurname, String company) {
        if (nameAndSurname != null && !nameAndSurname.isEmpty() && !nameAndSurname.isBlank()) {
            this.nameAndSurname = nameAndSurname;
        } else {
            this.nameAndSurname = "Петрович";
        }
        if (company != null && !company.isEmpty() && !company.isBlank()) {
            this.company = company;
        } else {
            this.company = "Тачка и точка";
        }
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public String getCompany() {
        return company;
    }

        public boolean service(P p) {
            return p.getDiagnosed();
        }

        public void repair (P p) {
        p.repair ();
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return nameAndSurname.equals(mechanic.nameAndSurname) && company.equals(mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameAndSurname, company);
    }

    @Override
    public String toString() {
        return nameAndSurname + ", из компании " + company;
    }
}
