package Cars;
import lombok.Getter;

@Getter
public class Audi extends Car {

    private final String brand = "Audi";
    public Audi(String name, int year, String color, boolean used, String transmission) {
        super(name, year, color, used, transmission);
    }

    @Override
    public void Sound(){
        if(isUsed())
            System.out.println("phphphpfdsqg");
        else{
            System.out.println("phphph");
        }
    }
}
