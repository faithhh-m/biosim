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
    private int hibernations;
    
    public Person(double x, double y, ArrayList<Person> bobs){
        energy=500;
        this.x=x;
        this.y=y;
        this.bobs=bobs;
        alive = true;
        bobcolor=Color.CYAN;
        age=0;
        size=20;
    }
    
    public ArrayList<Person> objects(){
        return bobs;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public int intX(){
        return (int)x;
    }
    
    public int intY(){
        return (int)y;
    }
    
    public void move(){
        x+=speed*Math.cos(Math.toRadians(direction));
        y+=speed*Math.sin(Math.toRadians(direction));
    }
    
    public double direction(){
        return direction;
    }
    
    public void increaseHibernations(){
        hibernations++;
    }
    
    public int getHibernations(){
        return hibernations;
    }
    
    //write a boolean method that returns true when the hibernation has ended. to be used in the age method
    
    public void doSomething(){
        move;
    }
    
    public int getEnergy(){
        return energy;
    }
    
    public void decreaseEnergy(){
        energy--;
    }
    
    public boolean alive(){
        return alive;
    }
    
    public void dead(){
        alive = false;
    }
    
    public Color getColor(){
        return bobcolor;
    }
    
    public void newColor(Color newcolor){
        bobcolor=newcolor;
    }
    
    public double size(){
        return size;
    }
    
    public int intSize(){
        return (int)size;
    }
    
    public void changeSize(double newsize){
        size = newsize;
    }
    
    public int distance(Person bob){
        int distance = 0; //fix this!!!
        return distance;
    }
    
    //will check if bob has bumped into food. if so, eat food
    public void eat(){
        for(int k=0;k<bobs.size()-1;k++){
            Person thisBob = bobs.get(k);
            //requires the distance method
        }
    }
    
    //this method will change the speed of the bobs depending on their age. will also increase age
    public void age(){
        for(int b=0; b<bobs.size(); b++){
            //if number of hibernations increases by 1, increase age by 1
            //use conditions to change speed
        }
    }
    
    public void spawn(){
        //use math.random to calculate probability of spawning
    }
    
    public void energyLevel(){
        decreaseEnergy();
    }
    
    public void create(Graphics draw){
        draw.setColor(getColor());
        draw.fillRect(intX(), intY(), intSize(), intSize());
    
}
