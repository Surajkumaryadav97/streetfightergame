package com.gamestreetfighter.gaming.canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.gamestreetfighter.gaming.sprites.KenPlayer;
import com.gamestreetfighter.gaming.sprites.Power;
import com.gamestreetfighter.gaming.sprites.PowerEffect;
import com.gamestreetfighter.gaming.sprites.RyuPlayer;
import com.gamestreetfighter.gaming.sprites.camera;
import com.gamestreetfighter.gaming.utils.GameContants;
import com.gamestreetfighter.gaming.utils.PlayerConstants;

public class Board extends JPanel implements GameContants,PlayerConstants {
	BufferedImage imageBg;
	private RyuPlayer ryuplayer;
	private KenPlayer kenplayer; 
	private Timer timer;
	private Power ryuPower;
	private Power kenPower;
	private boolean isGameOver;
	private camera Camera;
    	private void loadPower() {
		ryuPower=new Power(20,"Ryu".toUpperCase());
		kenPower=new Power(GWIDTH/2+100,"Ken".toUpperCase());
	}
	private void paintPower(Graphics pen) {
		ryuPower.printBox(pen);
		kenPower.printBox(pen);
	}
	
   public Board() throws IOException {
	 Camera=new camera();
	 //loadBackgroundImage();
	 ryuplayer=new RyuPlayer();
	 kenplayer=new KenPlayer();
	 setFocusable(true);
	 bindEvents();
	 gameLoop();
	 loadPower();
   }
   public void collision() {
	   if(isCollide()) {
		   if(ryuplayer.isAttacking()) {
			   kenplayer.setCurrentMove(DAMAGE);
			   kenPower.setHealth();
		   }
		   if(kenPower.getHealth()<=0||ryuPower.getHealth()<=0) {
			   isGameOver=true;
		   }
		   ryuplayer.setCollide(true);
		   ryuplayer.setSpeed(0);
	   }
	   else {
		   ryuplayer.setSpeed(SPEED);
		   ryuplayer.setCollide(false);
	   }
   }
   private void printMessage(Graphics pen) {
	   pen.setColor(Color.RED);
	   pen.setFont(new Font("times",Font.BOLD,40));
	   pen.drawString("GAME OVER",GWIDTH/2-50, GHEIGHT/2-50);
   }
   private boolean isCollide() {
	   int xDistance=Math.abs(ryuplayer.getX()-kenplayer.getX());
	   int yDistance=Math.abs(ryuplayer.getY()-kenplayer.getY());
	   int maxW=Math.max(ryuplayer.getW(),kenplayer.getW());
	   int maxH=Math.max(ryuplayer.getH(),kenplayer.getH());
	   return xDistance<=maxW-30&&yDistance<=maxH;
   }
   private void gameLoop() {
	   timer=new Timer(100,new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			ryuplayer.fall();
			collision();
			
		}
	
	   });
		timer.start();
   }
   public void printPower(Graphics g) {
	   for(PowerEffect power:ryuplayer.getPowers()) {
		   power.printPower(g);
	   }
   }
   private void bindEvents() {
	   this.addKeyListener(new KeyAdapter() {
		   

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				ryuplayer.setSpeed(-SPEED);
				Camera.setSpeed(-SPEED);
				ryuplayer.setCurrentMove(WALK);
				Camera.move();
				ryuplayer.move();
				repaint();
			}
			else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(ryuplayer.isCollide()) {
				ryuplayer.setSpeed(0);
				Camera.setSpeed(0);
			}
			else {
			    ryuplayer.setSpeed(SPEED);
			    Camera.setSpeed(SPEED);
			    
			}
			    ryuplayer.setCurrentMove(WALK);
			    ryuplayer.move();
			    Camera.move();
			    repaint();
			}
			else if(e.getKeyCode()==KeyEvent.VK_K) {
				   ryuplayer.setAttacking(true);
				   ryuplayer.setCurrentMove(KICK);
			}
			else if(e.getKeyCode()==KeyEvent.VK_P) {
				   ryuplayer.setAttacking(true);
				   ryuplayer.setCurrentMove(PUNCH);
			}
			else if(e.getKeyCode()==KeyEvent.VK_A) {
				 ryuplayer.setAttacking(true);
				 ryuplayer.setCurrentMove(POWER_EFFECT);
				 ryuplayer.addPower();
			}
			else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				   ryuplayer.jump();
			}
			else if(e.getKeyCode()==KeyEvent.VK_J) {
				kenplayer.setSpeed(-SPEED);
				kenplayer.move();
				repaint();
			}
			else if(e.getKeyCode()==KeyEvent.VK_L) {
				kenplayer.setSpeed(SPEED);
				kenplayer.move();
				repaint();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			ryuplayer.setSpeed(0);
			
		}
		   
	   });
   
   }
   public void paintComponent(Graphics g) {
	   super.paintComponent(g);
	   printBackgroundImage(g);
	   ryuplayer.printPlayer(g);
	   kenplayer.printPlayer(g);
	   paintPower(g);
	   printPower(g);
	   if(isGameOver) {
		   printMessage(g);
		   timer.stop();
	   }
   }
   private void printBackgroundImage(Graphics g) {
	   g.drawImage(Camera.defaultImage(),0,0,1200,550,null);
   }
   private void loadBackgroundImage() {
	   try {
		   imageBg=ImageIO.read(Board.class.getResource("bg1.jpg"));
		   }
		
		catch(Exception ex) {
			System.out.println("Backgroung Image Loading");
			System.exit(0);
		}
   }
   
}
