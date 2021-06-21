import java.awt.Color;
import java.util.ArrayList;

public class Bob extends Person {
    
   public Bob(double x, double y, ArrayList<Person> actors){
       super(x, y, actors);
   }
   
   public void spawn(){
       if(getAge()>=3){
           double probability = Math.random();
           System.out.println(probability);
           if((probability<=0.4)&&(getEnergy()>=900)){
               createObject();
               setEnergy(600);
               System.out.println("Creating new Bob...");
           }
       }
   }
   
   public void movement(){
       if(distance(400,300)>350){
           double center = setDirection(400,300);
           setDirection(center);
       }
   }
    
   //check this method
   @Override
   public void createObject(){
       Person spawn = new Bob(getX(), getY(), actors());
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
           if(actors().get(k).getEnergy()>1000){
               //add code to share food here, may require food class to be coded first
           }
           else if(actors().get(k).getEnergy()==0){
               dead();
           }
           else if(actors().get(k).getEnergy()<=100){
               actors().get(k).newColor(Color.RED);
           }
       }
   }
}
