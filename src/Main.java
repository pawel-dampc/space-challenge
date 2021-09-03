import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        double averageU1 = 0;
        double averageU2 = 0;
        double sample = 10000;


        File file = new File("phase-1.txt");
        Simulation simulation = new Simulation();
        simulation.loadItems(file);
        simulation.loadU1();
        simulation.loadU2();

        File file2 = new File("phase-2.txt");
        Simulation simulation2 = new Simulation();
        simulation2.loadItems(file2);
        simulation2.loadU1();
        simulation2.loadU2();
        for (int i=0; i<sample; i++) {
            averageU1 += (simulation.runSimulation(simulation.u1Rockets) + simulation2.runSimulation(simulation2.u1Rockets))/sample;
        }
        for (int i=0; i<sample; i++) {
            averageU2 += (simulation.runSimulation(simulation.u2Rockets) + simulation2.runSimulation(simulation2.u2Rockets))/sample;
        }

        System.out.println("Average cost of U1 rocket fleet is: " + (int) averageU1 + ".");
        System.out.println("Average cost of U2 rocket fleet is: " + (int) averageU2 + ".");


    }
}
