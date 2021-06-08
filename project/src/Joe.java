import java.util.ArrayList;
import java.awt.Color;

public class Joe extends Person{
    
    public Joe(double x, double y, ArrayList<Person> bobs){
        super(x,y,bobs);
        newColor(Color.MAGENTA);
    }
    
    @Override
    public void doSomething(){
        move();
        energyLevel();
        eat();
        age();
    }
    
    @Override
    public void energyLevel(){
        decreaseEnergy();
        for(int k=0; k<bobs.size(); k++){
            if(bobs.get(k).getEnergy()==0){
                dead();
            }
            else if(bobs.get(k).getEnergy()<=100){
                bobs.get(k).newColor(Color.DARK_GRAY);
            }
        }
    }
    
}
