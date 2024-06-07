package com.gamestreetfighter.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class RyuPlayer extends Sprite {
	private BufferedImage loadImages[]=new BufferedImage[6];
	private BufferedImage StandingImages[]=new BufferedImage[8];
	private BufferedImage KickImages[]=new BufferedImage[6];
	private BufferedImage PunchImages[]=new BufferedImage[6];
	private BufferedImage powerEffectImages[]=new BufferedImage[5];
    public RyuPlayer() throws IOException {
    	x=100;
    	h=200;
    	w=200;
    	y=FLOOR-h;
    	speed=0;
    	currentMove=STANDING;
    	imageIndex=0;
    	image=ImageIO.read(RyuPlayer.class.getResource(RYU_IMAGE));
    	loadWalkImages();
    	loadStandingImages();
    	loadKickImages();
    	loadPunchImages();
    	loadPowerEffectImages();
    }
     public void jump() {
    	if(!isJump) {
    	 force=DEFAULT_FORCE;
    	 y=y+force;
    	 isJump=true;
    	}
     }
    public void fall() {
    if(y>=(FLOOR-h)) {
    	isJump=false;
    	return;
    }
    	force=force+GRAVITY;
    	y=y+force;
    }
      private void loadWalkImages() {
    	loadImages[0] = image.getSubimage(62, 235, 73, 103);
		loadImages[1] =  image.getSubimage(141, 230, 74, 105);
		loadImages[2] = image.getSubimage(224, 231, 67, 103);
		loadImages[3] =  image.getSubimage(302, 231, 62, 104);
		loadImages[4] =  image.getSubimage(374, 232, 66, 100);
		loadImages[5] =  image.getSubimage(454, 234, 67, 104);
    }
    private void loadStandingImages() {
    	StandingImages[0]=image.getSubimage(14, 4,73,106 );
    	StandingImages[1]=image.getSubimage(87,4,68,107 );
    	StandingImages[2]=image.getSubimage(164,4,72,108 );
    	StandingImages[3]=image.getSubimage(241,1,72,110 );
    	StandingImages[4]=image.getSubimage(321,6,70,107 );
    	StandingImages[5]=image.getSubimage(396,4,61,105);
    	StandingImages[6]=image.getSubimage(464,4,62,109 );
    	StandingImages[7]=image.getSubimage(534,4,63,109 );
    
    }
    private void loadKickImages() {
    	KickImages[0]=image.getSubimage(38,1043,69,103);
    	KickImages[1]=image.getSubimage(120,1043,69,98);
    	KickImages[2]=image.getSubimage(198,1040,122,104);
    	KickImages[3]=image.getSubimage(328,1046,72,99);
    	KickImages[4]=image.getSubimage(409,1046,69,100);
    	KickImages[5]=image.getSubimage(482,1045,92,104);
    }
    private void loadPunchImages() {
    	PunchImages[0]=image.getSubimage(26,819,70,102);
    	PunchImages[1]=image.getSubimage(106,821,72,100);
    	PunchImages[2]=image.getSubimage(187,821,115,100);
    	PunchImages[3]=image.getSubimage(310,819,78,99);
    	PunchImages[4]=image.getSubimage(402,816,108,102);
    	PunchImages[5]=image.getSubimage(517,821,79,100);
    }
    private void loadPowerEffectImages() {
    	powerEffectImages[0]=image.getSubimage(4,1807,116,99);
    	powerEffectImages[1]=image.getSubimage(124,1808,118,97);
    	powerEffectImages[2]=image.getSubimage(251,1812,122,93);
    	powerEffectImages[3]=image.getSubimage(382,1814,102,93);
    	powerEffectImages[4]=image.getSubimage(489,1813,148,92);
    }
    
    private BufferedImage walkImage() {
    	if(imageIndex>5) {
   		 imageIndex=0;
   		currentMove=STANDING;
   	 }
   	 BufferedImage img=loadImages[imageIndex];
   	 imageIndex++;
   	 return img;
    }
    private BufferedImage standingImage() {
    	if(imageIndex>7) {
   		 imageIndex=0;
   		 
   	 }
   	 BufferedImage img=StandingImages[imageIndex];
   	 imageIndex++;
   	 return img;
    }
    private BufferedImage powerEffectImage() {
    	if(imageIndex>4) {
   		 imageIndex=0;
   		currentMove=STANDING;
   		isAttacking=false;
   	 }
   	 BufferedImage img=powerEffectImages[imageIndex];
   	 imageIndex++;
   	 return img;
    }
    
    private BufferedImage kickImage() {
    	if(imageIndex>5) {
   		 imageIndex=0;
   		currentMove=STANDING;
   		isAttacking=false;
   	 }
   	 BufferedImage img=KickImages[imageIndex];
   	 imageIndex++;
   	 return img;
    }
    private BufferedImage punchImage() {
    	if(imageIndex>5) {
   		 imageIndex=0;
   		currentMove=STANDING;
   		isAttacking=false;
   	 }
   	 BufferedImage img=PunchImages[imageIndex];
   	 imageIndex++;
   	 return img;
    }
    private ArrayList<PowerEffect> powers=new ArrayList<>();
    public ArrayList<PowerEffect> getPowers(){
    	return powers;
    }
   public void addPower() {
	   powers.add(new PowerEffect(x+w,y+h/2-40,image));
   }
 public BufferedImage defaultImage() {
      if(currentMove==WALK) {
		 return walkImage();
	 }
	 else if(currentMove==PUNCH) {
		 return punchImage();
	 }
 else if(currentMove==KICK) {
		 return kickImage();
	 }
 else if(currentMove==POWER_EFFECT) {
	 return powerEffectImage();
 }
  return standingImage();
 
 }
   
}
