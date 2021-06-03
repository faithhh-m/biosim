import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Person {
    private int energy;
    private double x;
    private double y;
    private ArrayList<Person> bobs;
    private boolean alive = true;
    private Color bobcolor;
    private int age;
    private double size;
    
    public Person(double x, double y, ArrayList<Person> bobs){
        energy=500;
        this.x=x;
        this.y=y;
        this.bobs=bobs;
        alive = true;
        bobcolor=Color.CYAN;
        age=0;
        size=15;
    }
    
    public int getEnergy(){
        return energy;
    }
    
    public boolean alive(){
        return alive;
    }
    
    public void dead(){
        alive = false;
    }
    
    public int distance(Person bob){
        int distance = 0; //fix this!!!
        return distance;
    }
    
    //will check if bob has bumped into food. if so, eat food
    public void bump(){
        for(int k=0;k<bobs.size()-1;k++){
            Person thisBob = bobs.get(k);
            //requires the distance method
        }
    }
    
    //this method will change the speed of the bobs depending on their age
    public void age(){
        for(int b=0; b<bobs.size(); b++){
            //if number of hibernations increases by 1, increase age by 1
        }
    }
    
    public void energyLevel(){
        for(int j=0; j<bobs.size(); j++){
            if(energy>1000){
            //add code to drop trail of food here (move to separate bob class?)
            bobs.get(j);
            }
            if(energy==0){
                dead();
            }
            else if(energy<=100){
                bobcolor=Color.RED;
            }
            else{
                bobcolor=Color.CYAN;
            }
        }
    }
    
}
