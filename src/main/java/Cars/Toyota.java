package Cars;
import lombok.Getter;

@Getter
public class Toyota extends Car {

    private final String brand = "Toyota";
    public Toyota(String name, int year, String color, boolean used, String transmission) {
        super(name, year, color, used, transmission);
    }

    @Override
    public void Sound(){
        if(isUsed())
            System.out.println("ratatatdsgh");
        else{
            System.out.println("ratata");
        }
    }
}
