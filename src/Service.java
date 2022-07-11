import java.util.List;

public interface Service {
     void changeDriver(Truck truck, Driver driver);

     void startDriving(Truck truck, Driver driver);

     void startRepair(Truck truck, Driver driver);
}
