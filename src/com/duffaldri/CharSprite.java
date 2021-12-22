package com.duffaldri;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class CharSprite {
	int x, y;
	int width, height;
	Color color;
	BufferedImage image;
	
	int minX;
	int minY;
	
	Audio wave;
	
	public CharSprite(Color color) {
		this.width = 27;
		this.height = 96;
		this.color = color;
		
		this.wave = new Audio("wave-2.wav");
		wave.play();
	}
	
	public boolean bulletHit (Bullet bullet) {		
		if (((bullet.x > minX && bullet.x < minX + width) 
				|| (bullet.x + bullet.width > minX && bullet.x + bullet.width < minX + width)) 
				&& (bullet.y >= minY && bullet.y <= minY + height)) {
			return(true);
		} return(false);
	}
}

