/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ashwi
 */
public class GamePlay extends JPanel implements ActionListener, KeyListener{
     //private Thread thread;
     Timer timer;
     HumanPaddle p1;
     //ComputerPaddle p2;
     HumanPaddle p2;
     Ball ball;
     
     private boolean play = false;
     //private Graphics gfx;
     //private Image img;
    
// NOTE: THIS WAS USING APPLET & ECLIPSE.....the init() ; paint(Graphics g) ; update(Graphics g) are like default classes of an Applet class
// these are the functions that kinda have to be in the program
    
    public GamePlay(){
    p1 = new HumanPaddle(1);
    ball = new Ball();
    //p2 = new ComputerPaddle(2,ball);
    p2 = new HumanPaddle(2);
    //img = createImage(WIDTH, HEIGHT);
    //gfx = img.getGraphics();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    
    timer = new Timer(10,this);
    timer.start();
    
    //thread = new Thread(this);
    //thread.start();
    }
  
    public void paint(Graphics g){
        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, 700, 500);
        
        
        if(ball.getX() < -10 || ball.getX() > 710){
            play = false;
            g.setColor(Color.RED);
            g.drawString("Game Over", 330,250);
            g.drawString("Press SPACE to restart.", 300, 290);
        }else{
        p1.draw(g);
        ball.draw(g);
        p2.draw(g);
        }
        // Begin Screen where you press SPACE to start playing
        /*if(!play){
            g.setColor(Color.white);
            g.drawString("Tennis", 340, 100);
            g.drawString("Press SPACE to Begin.", 310, 130);
        }*/
        
        g.dispose();
       // g.drawImage(img, 0, 0, this);
    }
    
    /*public void run(){
        for(;;){
            repaint();
            if(play){
            p1.move();
            ball.move();
            p2.move();
            ball.checkPaddleCollision(p1,p2);
        }   
            repaint();
            try{
            Thread.sleep(10);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
    
        }
    }*/
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        timer.start();
        if(play == true){
            p1.move();
            ball.move();
            p2.move();
            ball.checkPaddleCollision(p1,p2);
        }
        repaint();
        try{
            Thread.sleep(10);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            p1.setUpAccel(true);
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            p1.setDownAccel(true);
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            p2.setUpAccel(true);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p2.setDownAccel(true);
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(!play){
            play = true;
            p1.y = 210;
            p1.x = 20;
            p2.y = 210;
            p2.x = 660;
            ball.x = 350;
            ball.y = 250;
            ball.xVel = ball.getRandomDirection()*ball.getRandomSpeed();
            ball.yVel = ball.getRandomDirection()*ball.getRandomSpeed();
            p1.move();
            ball.move();
            p2.move();
            ball.checkPaddleCollision(p1,p2);
            repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            p1.setUpAccel(false);
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            p1.setDownAccel(false);
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            p2.setUpAccel(false);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p2.setDownAccel(false);
        }
    }

    
    
    
}

