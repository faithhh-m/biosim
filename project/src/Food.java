import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Food extends Person {
    
    public Food(double x, double y, ArrayList<Person> actors){
        super(x, y, actors);
        newColor(Color.PINK);
        changeSize(10);
    }
    
    @Override
    public void doSomething(){
    }
    
    @Override
    public void create(Graphics draw){
        draw.setColor(getColor());
        draw.fillOval(intX(), intY(), intSize(), intSize());
    }
}
