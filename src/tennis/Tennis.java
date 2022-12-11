/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennis;


import javax.swing.JFrame;

/*












This game can be oneplayer be changed p2 back to ComputerPaddle or 2player which is what its set to rn
need to add a score system, and add a condition of when the ball hits the top of the paddle
and maybe STYLE IT UP













*/

public class Tennis extends JFrame{
// for final variables, they must be in CAPS    
     static final int WIDTH = 700;
     static final int HEIGHT = 500;
 
    public static void main(String [] args){
        JFrame frame = new JFrame();
        
        frame.setBounds(0,0,700,529);
        frame.setTitle("Tennis");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePlay());
    }

    
    
}
