import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    private static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Truck truck1 = new Truck(1, "Renault Magnum", "driver", State.BASE);
        Truck truck2 = new Truck(2, "Volvo", "driver", State.BASE);
        Truck truck3 = new Truck(3, "DAF XT", "driver", State.BASE);
        Truck[] trucks = new Truck[]{truck1, truck2, truck3};


        Driver driver1 = new Driver(1, "Petr", "               ");
        Driver driver2 = new Driver(2, "Askar", "               ");
        Driver driver3 = new Driver(3, "Uson", "               ");
        Driver[] drivers = new Driver[]{driver1, driver2, driver3};

        print(trucks);
        print(drivers);
        System.out.println("******************************");
        while (true){
            System.out.println("Choose one of the trucks: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Service service = new ServiceImple();
            getInstruction();
            String action = scanner.nextLine();
            if (action.equals("1")) {
                service.changeDriver(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(trucks[input - 1], drivers[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(trucks[input - 1], drivers[input - 1]);
            }
            print(trucks);
            print(drivers);
        }
    }
    public static void print(Truck[] trucks) {
        System.out.println("~~~~~~~~~~~~ * TRUCKS * ~~~~~~~~~~~~");
        System.out.println(" # |    Bus    |  Driver  |  State");
        System.out.println("---+-----------+----------+---------");
        for (int j = 0; j < trucks.length; j++) {
            System.out.println(trucks[j]);
        }
    }
    public static void print(Driver[] drivers) {
        System.out.println("~~~~~~~~~~ * DRIVERS * ~~~~~~~~~~~~~");
        System.out.println("     #    |   Driver   |   Bus      ");
        System.out.println("----------+------------+------------");
        for (int j = 0; j < drivers.length; j++) {
            System.out.println(drivers[j]);
        }
    }

    public static void getInstruction() {
        System.out.println("Select -1- to change driver ");
        System.out.println("Select -2- to start driving ");
        System.out.println("Select -3- to start repairing ");
    }
}
