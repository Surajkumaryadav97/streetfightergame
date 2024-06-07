package com.gamestreetfighter.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gamestreetfighter.gaming.canvas.Board;

public class camera extends Sprite {
	private int moveBlock=0;
	private RyuPlayer ryuplayer;
	private KenPlayer kenplayer;
	public camera() throws IOException {
		x=11;
		y=300;
		w=1400;
		h=900;
		image=ImageIO.read(Board.class.getResource("bg1.jpg"));
	}
	public void move() {
		outOfScreen();
		if(moveBlock==1) {
			speed=10;
		}
		else if(moveBlock==2) {
			speed=-10;
		}
		
		x=x+speed;
	}
    public void outOfScreen() {
    	if(x<=10) {
    		moveBlock=1;
    		
    	}
    	else if(x>=3000-1400) {
    		moveBlock=2;
    		speed=0;
    	}
    	else {
    		moveBlock=0;
    	}
    }
	@Override
	public BufferedImage defaultImage() {
		BufferedImage subImage=image.getSubimage(x,y,w,h);
		return subImage;
	}

}
