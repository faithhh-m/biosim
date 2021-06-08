import java.awt.Color;
import java.util.ArrayList;

public class Bob extends Person {
    
   public Bob(double x, double y, ArrayList<Person> bobs){
       super(x, y, bobs);
   }
   
   public void doSomething(){
       //do something
   }
   
   @Override
   public void energyLevel(){
       decreaseEnergy();
       for(int k=0; k<bobs.size(); k++){
           if(bobs.get(k).getEnergy()>1000){
               //add code to drop trail of food here, requires food class to be coded
           }
           else if(bobs.get(k).getEnergy()==0){
               dead();
           }
           else if(bobs.get(k).getEnergy()<=100){
               bobs.get(k).newcolor(Color.RED);
           }
       }
   }
}
