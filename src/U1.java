class U1 extends Rocket {
    {
        rocketCost = 100;
        rocketWeight = 10000;
        maxWeight = 18000;
        cargoCarried = 0;
        cargoLimit = maxWeight - rocketWeight;

    }

    public boolean launch() {
        return Math.random() >= 0.05 * cargoCarried / cargoLimit;
    }

    public boolean land() {
        return Math.random() >= 0.01 * cargoCarried / cargoLimit;
    }
}
