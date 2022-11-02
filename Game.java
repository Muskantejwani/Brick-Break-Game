import java.util.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.swing.*;

import java.awt.*;

import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
public class Game extends JPanel implements KeyListener, ActionListener 
{	 Audio ob=new Audio();
Audio1 obb=new Audio1();
	private boolean play = false;
	private int score = 0;
	int poY=570;int xx=0;
	private int totaleggs = 126;
	int blx=90,bly=70;
	private Timer timer;
	private int delay=1;
	Rectangle ballRect;
	private int playerX = 310;
	private int playerY=592;
	private int ballpX = 120;
	private int ballpY = 350;
	private int balldiX = -1;
	private int balldiY = -2;
	private int ballpXX = 180;
	private int ballpYY = 350;
	private int balldiXX = -1;
	private int balldiYY = -2;
	private JPanel contentPane;
	Rectangle eggRect;
	Rectangle ballRec;
	Rectangle eggRec;
	public boolean gol;
	private Map map;
	 private JFrame gam;
	    private Random run=new Random();
	   private float  red,green, blue;
	public Game() {
		
		map = new Map(7,18);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	
		 red=run.nextFloat();
		   blue=run.nextFloat();
		   green=run.nextFloat();
	}

	public void paint(Graphics g) {
		Graphics2D gr= (Graphics2D)g;
		
	 g.setColor(Color.black);
	g.fillRect(1, 1, 692, 592);
	// drawing map
	map.draw((Graphics2D) g);
	// borders
	
	g.setColor(Color.yellow);
	g.fillRect(0, 0, 692, 6);
	g.fillRect(0, 3, 8, 592);
	g.fillRect(679, 3, 6, 592);
	g.setColor(Color.red);
	g.fillRect(6, 6, 670, 3);	 
	g.fillRect(6, 8, 3, 585);
	g.fillRect(676, 6, 3, 570);
	
	// the scores 		
	g.setColor(Color.green);
	g.setFont(new Font("serif",Font.BOLD, 25));
	g.drawString(""+score, 10,40);
	
	// the paddle
	g.setColor(Color.green);
	g.fillRect(playerX, 530, 110, 11);
	int red=(int)(Math.random()*256);
	int blue=(int)(Math.random()*256);
	int green=(int)(Math.random()*256);
	Color startColor =new Color(red,blue,green);
	
	red=(int)(Math.random()*256);
	blue=(int)(Math.random()*256);
	green=(int)(Math.random()*256);
	Color endColor =new Color(red,blue,green);
	GradientPaint grPaint=new GradientPaint(ballpX,ballpY,startColor,30,30,endColor);
	gr.setPaint(grPaint);
	gr.fillOval(ballpX,ballpY,30,30);
	gr.fillOval(ballpXX,ballpYY,30,30);
		
	
	repaint();
	// when you won the game
	if(totaleggs <= 0)
	{
		 play = false;
         balldiX = 0;
 		 balldiY = 0;
 		 balldiXX = 0;
 		 balldiYY = 0;
         g.setColor(Color.green);
         g.setFont(new Font("Courier New",Font.BOLD, 32));
         g.drawString("You Won", 100,300);
         
        g.setColor(Color.green);
        g.setFont(new Font("Courier New",Font.BOLD, 25));           
         g.drawString("Press Enter to Restart....", 150,350);  
	}
	
	// when you lose the game
	 if(ballpYY >570)
	    { balldiXX = 0;
		balldiYY=0;
		play=true;}
	 if(ballpY >570)
	    { balldiX = 0;
		balldiY=0;
		play=true;}
	
	 if(ballpY > 570 && ballpYY >570)
    {
		obb.playSound();
		 play = false;
         balldiX = 0;
 		 balldiY = 0;
 		 balldiXX = 0;
 		 balldiYY = 0;
         g.setColor(Color.PINK);
         g.setFont(new Font("Courier New",Font.BOLD, 32));
         g.drawString("Game Over your Score is: "+score, 100,300);
         
         g.setColor(Color.PINK);
         g.setFont(new Font("Courier New",Font.BOLD, 25));           
         g.drawString("Press Enter to try again....", 150,340); 
    }
	g.dispose();
}	
	
public void keyPressed(KeyEvent e) 
{
	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	{        
		if(playerX >= 575)
		{
			playerX = 575;
		}
		else
		{
			play = true;
			playerX+=20;	
		}
    }
	
	if (e.getKeyCode() == KeyEvent.VK_LEFT)
	{          
		if(playerX <= 15)
		{
			playerX = 15;
		}
		else
		{
			play = true;
			playerX-=20;
		}
    }		
	if (e.getKeyCode() == KeyEvent.VK_ENTER)
	{          
		if(!play)
		{
			play = true;
			ballpX = 120;
			ballpY = 350;
			balldiX = -1;
			balldiY = -2;
			ballpXX = 180;
			ballpYY = 350;
			balldiXX = -1;
			balldiYY = -2;
			playerX = 310;
			score = 0;
			totaleggs = 126;
			int xx;
int a=10,b=10,c=10,d=10,f=10,g=10,h=10,i=10,j=10,k=10,l=10,m=10,n=10,o=10,p=10,q=10,r=10,s=10,t=10,u=10,v=10;
			map = new Map(7, 18);
			repaint();
		}}}
public void keyReleased(KeyEvent e) {}
public void keyTyped(KeyEvent e) {}
public void actionPerformed(ActionEvent e) 
{
	timer.start();
	if(play)
	{		
		if(new Rectangle(ballpX, ballpY, 30, 30).intersects(new Rectangle(playerX, 530, 30, 8)))
		{
			balldiY = -balldiY;
			balldiX = -2;
		}
		else if(new Rectangle(ballpXX, ballpYY, 30, 30).intersects(new Rectangle(playerX, 530, 30, 8)))
		{
			balldiYY = -balldiYY;
			balldiXX = -2;
		}
		else if(new Rectangle(ballpX, ballpY, 30, 30).intersects(new Rectangle(playerX + 70, 530, 30, 8)))
		{
			balldiY = -balldiY;
			balldiX = balldiX +1;
		}
		else if(new Rectangle(ballpXX, ballpYY, 30, 30).intersects(new Rectangle(playerX + 70, 530, 30, 8)))
		{
			balldiYY = -balldiYY;
			balldiXX = balldiXX +1;
		}
		else if(new Rectangle(ballpX, ballpY, 30, 30).intersects(new Rectangle(playerX + 30, 530, 40, 8)))
		{
			balldiY = -balldiY;
		}
		else if(new Rectangle(ballpXX, ballpYY, 30, 30).intersects(new Rectangle(playerX + 30, 530, 40, 8)))
		{
			balldiYY = -balldiYY;
		}
		// check map collision with the ball		
		A: for(int i = 0; i<map.map.length; i++)
		{
			for(int j =0; j<map.map[0].length; j++)
			{				
				if(map.map[i][j] > 0)
				{
					int eggX = j * map.eggWidth + 50;
					int eggY = i * map.eggHeight + 10;
					int eggWidth = map.eggWidth;
					int eggHeight = map.eggHeight;
					
					Rectangle rect = new Rectangle(eggX, eggY, eggWidth, eggHeight);					
					 ballRect = new Rectangle(ballpX, ballpY, 30, 30);
					 ballRec = new Rectangle(ballpXX, ballpYY, 30, 30);
					 eggRect = rect;
					 eggRec = rect;
					
					if(ballRect.intersects(eggRect) || ballRec.intersects(eggRec))
					{	ob.playSound();
						map.seteggValue(0, i, j);
						score+=10;	
						totaleggs--;
						int yyy=90;
						if(ballRect.intersects(ballRec)) {
							balldiX=-balldiX;
							
							balldiXX=+balldiXX;
							
							
						}
						
						if(ballpX + 19 <= eggRect.x || ballpX + 1 >= eggRect.x + eggRect.width)	
						{
							balldiX = -balldiX;
						}
						else
						{
							balldiY = -balldiY;				
						}
						 if(ballpXX + 19 <= eggRec.x || ballpXX + 1 >= eggRec.x + eggRec.width)	
						{
							balldiXX = -balldiXX;
						}
						
						// when ball hits top or bottom of brick
						else
						{
							balldiYY = -balldiYY;				
						}
						break A;
				}}}}
		
		ballpX += balldiX;
		ballpY += balldiY;
		
		ballpXX += balldiXX;
		ballpYY += balldiYY;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(ballpX < 15)
		{
			balldiX = -balldiX;
		}
		if(ballpY < 0)
		{
			balldiY = -balldiY;
		}
		if(ballpX > 645)
		{
			balldiX = -balldiX;
		}
		if(ballpXX < 15)
		{
			balldiXX = -balldiXX;
		}
		if(ballpYY < 0)
		{
			balldiYY = -balldiYY;
		}
		if(ballpXX > 645)
		{
			balldiXX = -balldiXX;
		}
		
		
		repaint();		
	}
}}
