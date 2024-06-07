package com.gamestreetfighter.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PowerEffect extends Sprite {
    public PowerEffect(int x,int y,BufferedImage img) {
    	this.image=img;
    	image.getSubimage(11, 3110, 62, 37);
    	this.x=x;
    	this.y=y;
    	w=80;
    	h=80;
    	speed=50;
    }
	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		return image.getSubimage(11, 3110, 62, 37);
	}
	public void printPower(Graphics pen) {
    	pen.drawImage(defaultImage(), x, y, w, h,null);
    	move();
    }

}
