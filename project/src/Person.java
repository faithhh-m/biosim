import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Person {
    private int energy;
    private double x;
    private double y;
    private double direction;
    private double speed;
    private ArrayList<Person> actors;
    private boolean alive = true;
    private Color bobcolor;
    private int age;
    private double size;
    private int hibernations;
    
    public Person(double x, double y, ArrayList<Person> actors){
        energy=500;
        this.x=x;
        this.y=y;
        this.actors=actors;
        alive = true;
        bobcolor=Color.CYAN;
        age=0;
        size=20;
        speed=1.0;
    }
    
    public ArrayList<Person> actors(){
        return actors;
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
        y+=-1*speed*Math.sin(Math.toRadians(direction));
    }
    
    public double direction(){
        return direction;
    }
    
    public double fixDirection(double angle){
        do{
            angle+=360;
        }while(angle<0);
        do{
            angle-=360;
        }while(angle>360);
        return angle;
    }
    
    public double setDirection(double x, double y){
        double distanceX = x-this.x;
        double distanceY = -(y-this.y);
        double radian = Math.atan2(distanceX, distanceY);
        double angle = Math.toRadians(radian);
        return fixDirection(angle);
    }
    
    public void setDirection(double newDirection){
        direction = newDirection;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public void setSpeed(double newSpeed){
        speed = newSpeed;
    }
    
    //check this method!
    public boolean increaseHibernations(){
        hibernations++;
        return true;
    }
    
    public int getHibernations(){
        return hibernations;
    }
    
    public void doSomething(){
        move();
    }
    
    public int getEnergy(){
        return energy;
    }
    
    public void decreaseEnergy(){
        energy--;
    }
    
    public void changeEnergy(){
        energy-=100;
    }
    
    public void setEnergy(int newEnergy){
        energy = newEnergy;
    }
    
    public int getAge(){
        return age;
    }
    
    public boolean getAlive(){
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
    
    public double distance(Person bob){
        if(bob==null){
            return -1;
        }
        return distance(bob.getX(), bob.getY());
    }
    
    public double distance(double x, double y){
        double distanceX=this.x-x;
        double distanceY=this.y-y;
        double distance=Math.pow((distanceX*distanceX+distanceY*distanceY), 0.5);
        return distance;
    }
    
    //will check if bob has bumped into food. if so, eat food
    public void eat(){
        for(int k=0;k<actors().size()-1;k++){
            Person thisActor = actors().get(k);
            if(thisActor instanceof Food && thisActor.isThisAlive()){
                if(distance(thisActor)<thisActor.size()){
                    thisActor.isDead();
                    energy+=100;
                }
            }
        }
    }
    
    //this method will change the speed of the bobs depending on their age. will also increase age
    public void age(){
        for(int b=0; b<actors().size(); b++){
            if(increaseHibernations()==true){
                age++;
            }
            switch (age){
                case 6: //kill when age is 6
                    dead();
                    break;
                case 5: //when age is 5
                    setSpeed(0.4);
                    break;
                case 4: //when age is 4
                    setSpeed(0.6);
                    break;
                case 3: //when age is 3
                    setSpeed(0.8);
                    break;
                default: //if age is 2, 1 or 0, nothing changes.
                    break;
            }
        }
    }
    
    //check this method
    public void createObject(){
        Person spawn = new Person(x,y,actors);
        actors.add(spawn);
    }
    
    public void energyLevel(){
        decreaseEnergy();
    }
    
    public void create(Graphics draw){
        draw.setColor(getColor());
        draw.fillOval(intX(), intY(), intSize(), intSize());
    }
    
}
