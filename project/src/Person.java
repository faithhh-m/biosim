import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Person {
    private int energy;
    private double x;
    private double y;
    private ArrayList<Person> actors;
    private boolean alive = true;
    private Color bobcolor;
    private int age;
    private double size;
    private int hibernations;
    private int speed;
    private double direction;
    
    public Person(double x, double y, ArrayList<Person> actors){
        energy=500;
        this.x=x;
        this.y=y;
        this.actors=actors;
        alive = true;
        bobcolor=Color.CYAN;
        age=0;
        size=15;
    }
    
    public double getX(){
        return x;
    }
    
    public int intX(){
        return (int)x;
    }
    
    public double getY(){
        return y;
    }
    
    public int intY(){
        return (int)y;
    }
    
    public void move(){
        x+=speed*Math.cos(Math.toRadians(direction));
        y+=-1*speed*Math.sin(Math.toRadians(direction));
    }
    
    public double getDirection(){
        return direction;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void increaseHibernations(){
        hibernations++;
    }
    
    public int getHibernations(){
        return hibernations;
    }
    
    public void doSomething(){
        move();
    }
    
    //check this method
    public boolean increaseHibernations(){
        hibernations++;
        return true;
    }
    
    public int getHibernations(){
        return hibernations;
    }
    
    public int getEnergy(){
        return energy;
    }
    
    public void decreaseEnergy(){
        energy--;
    }
    
    public int getAge(){
        return age;
    }
    
    public boolean isThisAlive(){
        return alive;
    }
    
    public void isDead(){
        alive = false;
    }
    
    public Color getColor(){
        return bobcolor;
    }
    
    public void newcolor(Color newcolor){
        bobcolor=newcolor;
    }
    
    public double getSize(){
        return size;
    }
    
    public int intSize(){
        return (int)size;
    }
    
    public void changeSize(double newsize){
        size = newsize;
    }
    
    public double distance(Person bob){
        if(bob==null){
            return -1;
        }
        return distance(bob.getX(), bob.getY());
    }
    
    public double distance(double x, double y){
        double distanceX=this.x-x;
        double distanceY=this.y-y;
        double distance = Math.pow((distanceX*distanceX+distanceY*distanceY), 0.5);
        return distance;
    }
    
    //will check if bob has bumped into food. if so, eat food
    public void eat(){
        for(int k=0;k<actors.size()-1;k++){
            Person thisActor = actors.get(k);
            if(thisActor instanceof Food && thisActor.isThisAlive()){
                if(distance(thisActor)<thisActor.getSize()){
                    thisActor.isDead();
                }
            }
        }
    }
    
    //this method will change the speed of the bobs depending on their age. will also increase age
    public void age(){
        for(int b=0; b<actors.size(); b++){
            if(increaseHibernations()==true){
                age++;
            }
            switch (age) {
                case 6: //kill when age is 6
                    isDead();
                    break;
                case 5: //when age is 5
                    //change speed
                    break;
                case 4: //when age is 4
                    //change speed
                    break;
                case 3: //when age is 3
                    //change speed
                    break;
                default: //when age is 1 or 2, nothing happens
                    break;
            }
        }
    }
    
    public void createObject(){
        Person spawn = new Person(x,y,actors);
        actors.add(spawn);
    }
    
    public void energyLevel(){
        decreaseEnergy();
    }
    
    //this method draws and creates the object
    public void create(Graphics draw){
        draw.setColor(getColor());
        draw.fillRect(intX(), intY(), intSize(), intSize());
    
}
