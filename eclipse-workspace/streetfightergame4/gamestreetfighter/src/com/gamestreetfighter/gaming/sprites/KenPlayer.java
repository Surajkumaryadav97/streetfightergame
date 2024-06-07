package com.gamestreetfighter.gaming.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gamestreetfighter.gaming.utils.GameContants;

public class KenPlayer extends Sprite {
	private BufferedImage[] damageImages=new BufferedImage[5];
    public KenPlayer() throws IOException {
      x=GWIDTH-250;
   	 y=FLOOR-h;
   	 speed=0;
   	 imageIndex=0;
      image=ImageIO.read(KenPlayer.class.getResource(KEN_IMAGE));
      loadDamageImage();
    }
    private void loadDamageImage() {
    	damageImages[0]=image.getSubimage(1361,3275,67,93);
    	damageImages[1]=image.getSubimage(1437,3273,84,100);
    	damageImages[2]=image.getSubimage(1535,3276,81,93);
    	damageImages[3]=image.getSubimage(1628,3277,70,96);
    	damageImages[4]=image.getSubimage(1709,3275,65,92);
    }
    public BufferedImage damageImage() {
    	if(imageIndex>=5) {
      		 imageIndex=0;
      		currentMove=STANDING;
      	 }
      	 BufferedImage img=damageImages[imageIndex];
      	 imageIndex++;
      	 return img;
    }
    public BufferedImage defaultImage() {
    	if(currentMove==DAMAGE) {
    		return damageImage();
    	}
    	BufferedImage subImage=image.getSubimage(1752, 688, 70, 92);
    	return subImage;
    }
}
