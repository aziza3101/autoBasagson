import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceImple implements Service {

    @Override
    public void changeDriver(Truck truck, Driver driver) {
        try{
            if (truck.getState().equals(State.BASE)){
                truck.setDriver(driver.getName());
                driver.setBus(truck.getName());
                if(driver.getName() == null){
                    System.out.println("Свободного водителя нет!");
                }else {
                    System.out.println("Теперь у машины " + truck.getName() + " назначен водитель " + driver.getName());
                }}
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public void startDriving(Truck truck, Driver driver) {
        if (truck.getState().equals(State.BASE)){
            if (!truck.getDriver().equals("")){
                truck.setState(State.ROUTE);
                System.out.println("Водитель успешно начал свой путь");
            }else {
                System.out.println("Здесь нет водителя");
            }
        }else if(truck.getState().equals(State.ROUTE)){
            System.out.println("Водитель уже в пути!");
        }else {
            Random random = new Random();
            int road = random.nextInt(2);
            if (road==0){
                truck.setState(State.ROUTE);
                System.out.println("Грузовик уже в пути");
            }else {
                truck.setState(State.BASE);
                System.out.println("Грузовик на базе");

            }
        }
    }
    @Override
    public void startRepair(Truck truck, Driver driver) {
        if (truck.getState().equals(State.BASE)) {
            truck.setState(State.REPAIR);
            System.out.println("Грузовик находится в СТО");
        } else if (truck.getState().equals(State.ROUTE)) {
            truck.setState(State.REPAIR);
        } else {
            System.out.println("Грузовик в ремонте");
        }
    }
}
