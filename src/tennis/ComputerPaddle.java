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
public class ComputerPaddle implements Paddle{
// x,y reps coordinates in the window panel, player reps if its player 1 or player 2 and determine if its left side of applet or rigth side 
 
    double y, yVel;
    boolean upAccel, downAccel;
    final double GRAVITY = 0.94;
    int player, x;
    Ball ball; 
    
    public ComputerPaddle(int player, Ball b){
        upAccel = false;
        downAccel = false;
        ball = b;
        y = 210;
        yVel = 0;
        if(player == 1){
            x = 20;
        }else{
            x = 660;
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);
    }

    
    public void move() {
        y = ball.getY() - 40;
        
        if(y<0){
            y=0;
        }else if(y >(500-80)){ //height of window - height of paddle bc its always referenced to the top left corner of paddle
            y =420;
        }
    }
    
    public int getY() {
        return (int)y;
    }
    
}
