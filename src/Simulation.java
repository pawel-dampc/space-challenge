import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Rocket> u1Rockets = new ArrayList<>();
    ArrayList<Rocket> u2Rockets = new ArrayList<>();
    ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        String inputLine;
        Scanner fileScanner = new Scanner(file);
        while(fileScanner.hasNextLine()) {
            inputLine = (fileScanner.nextLine());
            Item item = new Item();
            item.name = inputLine.substring(0,inputLine.indexOf("="));
            item.weight = Integer.parseInt(inputLine.substring(inputLine.indexOf("=")+1));
            items.add(item);
        }
        return items;
    }

    ArrayList<Rocket> loadU1() {
        ArrayList<Item> loadedItems = new ArrayList<>(items);
        while (loadedItems.size()>0) {
            U1 rocket = new U1();
            Item item;
            for (int i = 0; i < loadedItems.size(); i++) {
                item = loadedItems.get(i);
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                    loadedItems.remove(i);
                    i--;
                }
            }
            u1Rockets.add(rocket);
        }
        return u1Rockets;
    }

    ArrayList<Rocket> loadU2() {
        ArrayList<Item> loadedItems = new ArrayList<>(items);
        // Looping through items until there are any left
        while (loadedItems.size()>0) {
            U2 rocket = new U2();
            Item item;
            for (int i = 0; i < loadedItems.size(); i++) {
                item = loadedItems.get(i);
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                    loadedItems.remove(i);
                    i--;
                }
            }
            u2Rockets.add(rocket);
        }
        return u2Rockets;
    }

    long runSimulation(ArrayList<Rocket> rockets) {
        long simBudget = 0;
        for (Rocket value : rockets) {
            while (!(value.launch() && value.land())) {
                simBudget += value.rocketCost;
            }
            simBudget += value.rocketCost;
        }
        return simBudget;
    }
}
