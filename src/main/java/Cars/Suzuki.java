package Cars;
import lombok.Getter;

@Getter
public class Suzuki extends Car  {

    private final String brand = "Suzuki";
    public Suzuki(String name, int year, String color, boolean used, String transmission) {
        super(name, year, color, used, transmission);
    }

    @Override
    public void Sound(){
        if(isUsed())
            System.out.println("brbrbrbrbrgfdshs");
        else{
            System.out.println("brbrbrbrbr");
        }
    }
}
