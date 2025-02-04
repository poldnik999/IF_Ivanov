package Cars;
import lombok.Getter;

@Getter
public class Ford extends Car {

    private final String brand = "Ford";
    public Ford(String name, int year, String color, boolean used, String transmission) {
        super(name, year, color, used, transmission);
    }

    @Override
    public void Sound(){
        if(isUsed())
            System.out.println("rarararafaawhte");
        else{
            System.out.println("rarara");
        }
    }
}
