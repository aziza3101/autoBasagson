import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Driver {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./drivers.json");
    private int ID;

    private String name;
    private String bus;

    public Driver(int ID, String name, String bus) {
        this.ID = ID;
        this.name = name;
        this.bus = bus;
    }

    public Driver() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getDrivers() {
        Driver[] drivers = {new Driver(1, "driver-1", "Andrew"),
                new Driver(2, "driver-2", "Mane"),
                new Driver(3, "driver-3", "Rashword")
        };

        Gson gson = new Gson();
        String json = GSON.toJson(drivers);
        System.out.println(readDriverFile());
        writeDriverFile(json);

        Driver[] drivers1 = GSON.fromJson(readDriverFile(), Driver[].class);
        for (Driver driver : drivers1) {
            System.out.println(driver.toString());
        }

        return json;
    }

    private static void writeDriverFile(String object) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readDriverFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int id;
            while ((id = fileReader.read()) != -1) {
                json += (char) id;
            }
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    @Override
    public String toString() {
        return ID + "   |  " + name + "     |" + bus + '\n';

    }
}
