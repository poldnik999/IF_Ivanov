package Cars;
import lombok.Getter;

@Getter
public class Chevrolet extends Car {

    private final String brand = "Chevrolet";
    public Chevrolet(String name, int year, String color, boolean used, String transmission) {
        super(name, year, color, used, transmission);
    }

    @Override
    public void Sound(){
        if(isUsed())
            System.out.println("papapapahdnfg");
        else{
            System.out.println("papapa");
        }
    }
}
