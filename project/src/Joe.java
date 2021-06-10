import java.util.ArrayList;
import java.awt.Color;

public class Joe extends Person{
    
    public Joe(double x, double y, ArrayList<Person> actors){
        super(x,y,actors);
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
    
    //check this
    @Override
    public void createObject(){
        Person spawn = new Joe(getX(), getY(), actors());
        actors().add(spawn);
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
        for(int k=0; k<actors().size(); k++){
            if(actors().get(k).getEnergy()==0){
                isDead();
            }
            else if(actors().get(k).getEnergy()<=100){
                actors().get(k).newColor(Color.DARK_GRAY);
            }
        }
    }
    
}
