package Cars;

import lombok.Getter;

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

    //Отображаем информацию об авто
    private String ShowInfo(Car car) {
        String info = " " +
                car.getBrand() + " " +
                car.name + ", " +
                car.year + ", " +
                car.color + ", " +
                "Б/У?: "+ car.used + ", " +
                car.transmission;
        return info;
    }
    //Отображаем информацию об авто после определенного года
    public static void AutoAfterYear(Car car, int afterYear){
        if(car.year > afterYear){
            System.out.println("Новенький авто:" + car.ShowInfo(car));
        }
        else{
            System.out.println("Устаревший авто:" + car.ShowInfo(car));
        }
    }
    //Изменяем цвет авто
    public static void ChangeColor(Car car, String oldColor, String newColor){
        if(car.color == oldColor) {
            car.color = newColor;
            System.out.println("Теперь это авто " + newColor + ":" + car.ShowInfo(car));
        }
    }

    //Выводит звук у БУ автомобиля и их марку;
    public static void UsedAuto(Car car){
        if(car.used){
            System.out.print(car.getBrand() + " sound:    ");
            car.Sound();
        }

    }

    public abstract void Sound();
}
