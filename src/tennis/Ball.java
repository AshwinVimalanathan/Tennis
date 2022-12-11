/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ashwi
 */
public class Ball {
    double xVel, yVel, x, y;
    
    public Ball(){
        x = 350;
        y = 250;
        xVel = getRandomSpeed()*getRandomDirection();
        yVel = getRandomSpeed()*getRandomDirection();
    }
    
    public double getRandomSpeed(){
        return (Math.random()*3+2);
    }
    
    public int getRandomDirection(){
        int rand = (int)(Math.random()*2);
        if(rand ==1){
            return 1;
        }else{
            return -1;
        }
            
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(((int)x-10),((int)y-10),20,20); // the reason for the casting is obv because x,y are initially doubles
        // the reason for the minus 10 is bc the oval is drawn from the very top left corner which means the X, Y coordinates are the top left of the circle
        // and that where the circle will be drawn BUTTTT WE DOTN WANT THAT.......... WE WANT TO CENTER THAT POINT IN THE MIDDLE AND THEN DRAW THE CIRCLE
    }
    
    public void checkPaddleCollision(Paddle p1, Paddle p2){
        if(x <= 50){
            if(y >= p1.getY() && y <= p1.getY() + 80){
                xVel = -xVel;
            }
        }else if(x >= 650){
            if(y >= p2.getY() && y <= p2.getY() + 80){
                xVel = -xVel;
            }
        }
    }
    public void move(){
        x+=xVel;
        y+=yVel;
        
        if(y<10){// it is 10 and not 0 because rmbr the the center reference point is at 10,10
            yVel= -yVel;
        }
        if(y>490){
            yVel = -yVel;
        }
        
    }
    public int getX(){
        return (int)x;
    }
    
    public int getY(){
        return (int)y;
    }
}
