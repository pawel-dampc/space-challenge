public class Rocket implements SpaceShip {
    public long rocketCost;
    int rocketWeight;
    int maxWeight;
    double cargoCarried;
    double cargoLimit;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return !(item.weight + cargoCarried > maxWeight - rocketWeight);
    }
    public void carry(Item item) {
        cargoCarried = cargoCarried + item.weight;
    }
}
