/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import java.awt.*;
import static java.awt.Color.*;
import javax.swing.*;

/**
 *
 * @author kioooo
 */
public class Canvas extends JPanel{
    
    private int[] rannums = new int[3];
    
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        
        g.drawLine(this.getWidth()*1/3, 0,this.getWidth()*1/3, this.getHeight());
        g.drawLine(this.getWidth()*2/3, 0,this.getWidth()*2/3, this.getHeight());
        g.drawLine(0, this.getHeight()*2/3,this.getWidth(), this.getHeight()*2/3);
        
        g.drawString(String.valueOf(rannums[0]), (int)(this.getWidth()*1/6) ,this.getHeight()*2/5);
        g.drawString(String.valueOf(rannums[1]), (int)(this.getWidth()*3/6) ,this.getHeight()*2/5);
        g.drawString(String.valueOf(rannums[2]), (int)(this.getWidth()*5/6) ,this.getHeight()*2/5);
        
        
        g.setColor(getramcol(0));
        g.fillOval(0, this.getHeight()*1/3, 
                this.getWidth()*1/3, this.getHeight()*1/3);
        
        g.setColor(getramcol(1));
        g.fillOval(this.getWidth()*1/3,this.getHeight()*1/3, 
                this.getWidth()*1/3, this.getHeight()*1/3);
        
        g.setColor(getramcol(2));
        g.fillOval(this.getWidth()*2/3,this.getHeight()*1/3, 
                this.getWidth()*1/3, this.getHeight()*1/3);
        
        
    }
    
    public void genRams(){
        for (int i=0; i<rannums.length;i++)
            rannums[i] = (int)(Math.random()*3+1);
        
        this.repaint();
        
    }
    
    public int[] getRams(){
        return rannums;
        
    }
    
    public Color getramcol(int i){

        if(rannums[i]==1)
            return Color.red;
           
        else if(rannums[i]==2)
            return Color.blue;
        else
            return Color.yellow;
        
    }
    
    
}
