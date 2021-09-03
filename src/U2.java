class U2 extends Rocket {
    {
        rocketCost = 120;
        rocketWeight = 18000;
        maxWeight = 29000;
        cargoCarried = 0;
        cargoLimit = maxWeight - rocketWeight;
    }
    public boolean launch() {
        return Math.random() >= 0.04 * cargoCarried / cargoLimit;
    }

    public boolean land() {
        return Math.random() >= 0.08 * cargoCarried / cargoLimit;
    }
}