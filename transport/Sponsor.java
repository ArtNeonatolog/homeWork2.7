package transport;

import java.util.Objects;

public class Sponsor {

    private final String name;

    private final int sum;

    public Sponsor(String name, int sum) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = "Кока-кола";
        }
        if (sum < 100_000) {
            this.sum = 100_000;
        } else {
            this.sum = sum;
        }
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void sponsorRace () {

        System.out.printf("Спонсор \"%s\" проспонсировал заезд на %d%n", name, sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sponsor)) return false;
        Sponsor sponsor = (Sponsor) o;
        return sum == sponsor.sum && name.equals(sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sum);
    }

    @Override
    public String toString() {
        return name + ", сумма поддержки - " + sum;
    }
}
