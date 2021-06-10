import java.awt.Color;
import java.util.ArrayList;

public class Bob extends Person {
    
   public Bob(double x, double y, ArrayList<Person> bobs){
       super(x, y, bobs);
   }
   
   public void spawn(){
       if(getAge()>=3){
           double probability = Math.random();
           if(probability<=0.6){
               createObject();
           }
       }
   }
   
   //check this method
   @Override
   public void createObject(){
       Person spawn = new Bob(getX(), getY(), objects());
       objects().add(spawn);
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
           if(objects().get(k).getEnergy()>1000){
               //add code to share food here, may require food class to be coded first
           }
           else if(objects().get(k).getEnergy()==0){
               dead();
           }
           else if(objects().get(k).getEnergy()<=100){
               objects().get(k).newColor(Color.RED);
           }
       }
   }
}
