
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
class Main {
 public static void main(String args[]) {
  JFrame frame = new JFrame();
  Game obj=new Game();
	frame.setTitle("Breaker");
    frame.add(obj);
    frame.setSize(700, 600);
  frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
 
	
}}
