import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public class Joe extends Person{
    
    public Joe(double x, double y, ArrayList<Person> actors){
        super(x,y,actors);
        newColor(Color.MAGENTA);
    }
    
    public void spawn(){
        if(getAge()>=3){
            double probability = Math.random();
            Ssytem.out.println(probability);
            if((probability<=0.6)&&(getEnergy()>=900)){
                createObject();
                setEnergy(600);
                System.out.println("Creating new Joe...");
            }
        }
    }
    
    public void movement(){
        if(distance(400,300)>350){
           double center = setDirection(400,300);
           setDirection(center);
       }
    }
    
    @Override
    public void createObject(){
        Person spawn = new Joe(getX(), getY(), actors());
    }
    
    @Override
    public void doSomething(){
        move();
        energyLevel();
        eat();
        age();
        movement();
    }
    
    @Override
    public void energyLevel(){
        decreaseEnergy();
        for(int k=0; k<actors().size(); k++){
            if(actors().get(k).getEnergy()==0){
                dead();
            }
            else if(actors().get(k).getEnergy()<=100){
                actors().get(k).newColor(Color.DARK_GRAY);
            }
        }
    }
    
    @Override
    public void create(Graphics draw){
        draw.setColor(getColor());
        draw.fillOval(intX(), intY(), intSize(), intSize());
    }
}
