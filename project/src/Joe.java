import java.util.ArrayList;
import java.awt.Color;

public class Joe extends Person{
    
    public Joe(double x, double y, ArrayList<Person> bobs){
        super(x,y,bobs);
        newColor(Color.MAGENTA);
    }
    
    public void spawn(){
        if(getAge()>=3){
            double probability = Math.random();
            if(probability<=0.6){
                createObject();
            }
        }
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
        for(int k=0; k<objects().size(); k++){
            if(objects().get(k).getEnergy()==0){
                dead();
            }
            else if(objects().get(k).getEnergy()<=100){
                objects().get(k).newColor(Color.DARK_GRAY);
            }
        }
    }
    
}
