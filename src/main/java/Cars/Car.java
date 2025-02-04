package Cars;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public abstract class Car {

    private int year;
    private String transmission;
    private String name;

    private String color;
    private boolean used;
    private String brand;

    public Car(String name, int year, String color, boolean used, String transmission){
        this.name = name;
        this.year = year;
        this.color = color;
        this.used = used;
        switch (transmission){
            case("автоматическая"):
                this.transmission = "automatic";
                break;
            case("automatic"):
                this.transmission = "automatic";
                break;
            case("ручная"):
                this.transmission = "manual";
                break;
            case("manual"):
                this.transmission = "manual";
                break;
            default:
                this.transmission = "unknown";
                break;
        }
    }

    //Отображаем информацию об авто после определенного года
    public static void ShowInfo(List<Car> cars, int afterYear) {
        for(Car car : cars){
            if(car.year > afterYear){
                System.out.println("Новенький авто: " + car.name + ", " + car.year + ", " + car.color + ", " + car.used + ", " + car.transmission + ", " + car.getBrand());
            }
            else{
                System.out.println("Устаревший авто: " + car.name + ", " + car.year);
            }
        }
    }

    //Изменяем цвет авто
    public static void СhangeColor(List<Car> cars, String oldColor, String newColor){
        boolean clAuto = false;
        for(Car car : cars){
            if(car.color == oldColor) {
                clAuto = true;
                car.color = newColor;
                System.out.println("Теперь это авто " + newColor + ": "+ car.getBrand()+ " " + car.name + ", " + car.year + ", " + car.color);
            }
        }
        if(!clAuto)
            System.out.println(oldColor +" авто нет");
    }

    //Выводит звук у БУ автомобилей и их марку;
    public static void UsedAuto(List<Car> cars){
        for(Car car : cars){
            if(car.used == true){
                System.out.print(car.getBrand() + " sound:    ");
                car.Sound();

            }

        }
    }

    public abstract void Sound();
}
