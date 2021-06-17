
//imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends javax.swing.JFrame {

    //drawing and timer variables
    private Image ib;  
    private Graphics ibg;  
    private Color backgroundColor = new Color(150,255,150);
    
    //timer varibles
    private double delta_time;
    private long prev_time;
    public long tickCount=0;
    
    //timer object
    private Timer timer=null;
    private boolean active=false;
    
    //how long to wait between timer calls
    private int timerDelay = 20; 
    
    
    
    ArrayList<Person> person = new ArrayList<Person>();
    
    
    public GameScreen() {
        initComponents();
        
        
        setupSimulation();      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textTick = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(100, 150, 170));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        jLabel1.setText("Tick");

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel2.setText("Hibernation Simulator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textTick, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textTick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        //Set up the simulation, draw in caves etc etc. 
        System.out.println("New Simulation has begun.");
        System.out.println(" ");
        
        System.out.println("Current Bob count:  ");
        System.out.println("Current Joe count: ");
        System.out.println("Current food count: ");
        
        setupSimulation();
    }//GEN-LAST:event_buttonStartActionPerformed

    
    
    
    
    
    
    public void startTimer() {                                         
        if (timer!=null) {
            System.out.println("A timer is already working!");
            return;
        }
        //make a new timer object
        timer= new Timer(true);
        //make a timertask that has a job to do (call updateTime)
        TimerTask task= new TimerTask() {
            public void run() {
                tick();
            }
        };
        //tell timer to start repeating the task
        timer.scheduleAtFixedRate(task, 0, timerDelay);
        prev_time=System.nanoTime();
    } 
    
    /* This method will set the delta_time variable to how much time has past since the last time this
     * method was called.  You don't have to use this, but in video games you want to know how much 
     * time has elapsed so that you know how far to move moving game objects.
     */
   public void timeAdjust() {
        long curr_time=System.nanoTime();
        delta_time= (curr_time-prev_time)/1000000000.0;
        System.out.println(delta_time);
        prev_time=curr_time;
    }
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameScreen().setVisible(true);
            }
        });
  
        
    } //end for main 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textTick;
    // End of variables declaration//GEN-END:variables

    
    //called in constructor of this frame)
    public void setupSimulation() {        
        //add some actors to the actors list
        for(int k=1; k<2000; k++) {
            int xp=(int)(Math.random()*100)+1;
            int yp=(int)(Math.random()*100)+1;
            person.add(new Person(xp,yp,person) );
        }
        
        for(int k=1; k<10; k++) {
            int xp=(int)(Math.random()*800)+1;
            int yp=(int)(Math.random()*600)+1;
            person.add(new Food(xp,yp,person) );            
        }
    }
        
        
        
        //tick 
     
        public void tick(){
            // things that run 
            updateTicker();
        }
    
        //updates the tickCount
        public void updateTicker() {
            tickCount=tickCount+1;
            textTick.setText(""+tickCount);
        }
    
    
        public void updateActors() {
        //ask each actor to run its act() method
        for(int k=0; k<person.size(); k++ ) {
            Person temp = person.get(k); 
            if ( temp.isAlive() ) 
                temp.act();
        }
    }
    
    
} // J Frame end