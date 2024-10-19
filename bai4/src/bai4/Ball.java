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
public class Ball{
    private JPanel box;
    private static final int XSIZE=50;
    private static final int YSIZE=50;
    private static final int CAIGI=60;
    private int x=0;
    private int y=0;
    private int dx =10;
    private int dy=10;
    private Color color;
    public Ball(JPanel p)
{
        box = p;
        color=getRandomColor();
}
     private Color getRandomColor(){
        Random rand = new Random();
        return new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
    }
    public void draw(){
        Graphics g=box.getGraphics();
        g.fillOval(x,y,XSIZE,XSIZE);
        g.dispose();
    }
    public void move(){
        Graphics g =box.getGraphics();
        g.setColor(Color.white);
        g.fillOval(x, y, XSIZE, XSIZE);
        
        x+=dx;
        y+=dy;
        Dimension d = box.getSize();
        //kiemtra cos dung cac canh
        if(x<0){
            x=0;
            dx=-dx;
            color=getRandomColor();
        }
        if(x+XSIZE>=d.getWidth()){
            x=d.width-XSIZE;
            dx=-dx;
            color=getRandomColor();
        }
        if(y<0){
            y=0;
            dy=-dy;
            color=getRandomColor();
        }
        if(y+XSIZE>=d.getHeight()){
            y=d.height-XSIZE;
            dy=-dy;
            color=getRandomColor();
        }
       g.setColor(color);
        g.fillOval(x, y,XSIZE,XSIZE);
        g.dispose();
    }
    public void bounce(){
        draw();
        for(int i=0;i<1000;i++){
            move();
            try{
                Thread.sleep(10);
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