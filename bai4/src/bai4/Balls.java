/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Balls extends Thread {
    private JPanel box;
    private static final int XSIZE=50;
    private static final int YSIZE=50;
    private int x = 0;
    private int y=0;
    private int dx=4;
    private int dy =2;
    private Color color;
    public Balls(JPanel p){
        box=p;
        color=getRandomColor();
    }
    private Color getRandomColor(){
        Random rand = new Random();
        return new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
    }
    public void draw(){
        Graphics g=box.getGraphics();
        g.fillOval(x,y,XSIZE,YSIZE);
        g.dispose();
    }
    public void move(){
        Graphics g = box.getGraphics();
        g.setColor(Color.white);
        
        g.fillOval(x,y,XSIZE,YSIZE);
        x+=dx;
        y+=dy;
        Dimension d= box.getSize();
        //quá trái
         if(x<0){
            x=0;
            dx=-dx;
            color=getRandomColor();
        }
         //quá phải
        if(x+XSIZE>=d.getWidth()){
            x=d.width-YSIZE;
            dx=-dx;
            color=getRandomColor();
        }
        //quá trên
        if(y<0){
            y=0;
            dy=-dy;
            color=getRandomColor();
        }
        //quá dưới
        if(y+YSIZE>=d.getHeight()){
            y=d.height-YSIZE;
            dy=-dy;
            color=getRandomColor();
        }
        g.setColor(color);
        g.fillOval(x, y, XSIZE, XSIZE);
        g.dispose();
    }
     public void run(){
         boolean running=true;
        draw();
        for(int i=0;i<5000;i++){
            move();
            try{
                sleep(10);
            }catch(InterruptedException ex){
                JOptionPane.showMessageDialog(null,ex.toString(),"Thong bao loi",JOptionPane.ERROR_MESSAGE);
               
            }
           
        }
         Graphics g = box.getGraphics();
        g.setColor(Color.white);
        g.fillOval(x,y,XSIZE,YSIZE);
        g.dispose();
    }
}
