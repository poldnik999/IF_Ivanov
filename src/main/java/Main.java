import Cars.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main( String[] args )
    {
        List<Car> cars = Arrays.asList(
                new Audi("A1",2008,"blue",true,"manual"),
                new Audi("A3",2012,"red",true,"automatic"),
                new Chevrolet("Bolt_EV",2005,"green",false,"manual"),
                new Ford("Focus_ST",2008,"green",true,"automatic"),
                new Ford("Mondeo",2003,"black",false,"manual"),
                new Suzuki("Ignis",2001,"white",true,"automatic"),
                new Suzuki("Swift",2018,"orange",true,"manual"),
                new Toyota("Aygo_X",2006,"black",false,"automatic"),
                new Toyota("Aqua",2009,"magenta",false,"manual"),
                new Toyota("Corolla",2025,"green",true,"не_знаю")
        );
        //выводит информацию об автомобилях, выпущенных
        //после 2006 года, иначе выводит надпись «устаревший авто»
        Car.ShowInfo(cars, 2006);

        //изменяет цвет авто на красный, если у авто
        //зеленый цвет
        Car.СhangeColor(cars, "green", "red");

        //Выводит звук у БУ автомобилей и их марку;
        Car.UsedAuto(cars);
    }
}
