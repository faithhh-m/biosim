import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;

public class Bob extends Person {
    
   public Bob(double x, double y, ArrayList<Person> actors){
       super(x, y, actors);
   }
   
   public void spawn(){
       if(getAge()>=3){
           double probability = Math.random();
           if(probability<=0.4){
               createObject();
           }
       }
   }
   
   @Override
   public void createObject(){
       Person spawn = new Bob(getX(), getY(), actors());
       actors.add(spawn);
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
       for(int k=0; k<actors.size(); k++){
           if(actors.get(k).getEnergy()>1000){
               //add code to share food here, requires food class to be coded
           }
           else if(actors.get(k).getEnergy()==0){
               isDead();
           }
           else if(actors.get(k).getEnergy()<=100){
               actors.get(k).newcolor(Color.RED);
           }
       }
   }
    
   @Override
    public void create(Graphics draw){
        draw.setColor(getColor());
        draw.fillRect(intX(), intY(), intSize(), intSize());
    }
}
