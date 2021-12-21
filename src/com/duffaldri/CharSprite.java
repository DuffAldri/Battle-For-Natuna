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
	
	public CharSprite(Color color) {
		this.width = 27;
		this.height = 96;
		this.color = color;
	}
	
	public boolean bulletHit (Bullet bullet) {
//		int MinX = this.x;
//		int MinY = this.y + height;
//		int MaxX = this.x + width;
		
		if (((bullet.x > minX && bullet.x < minX + width) 
				|| (bullet.x + bullet.width > minX && bullet.x + bullet.width < minX + width)) 
				&& (bullet.y >= minY && bullet.y <= minY + height)) {
			return(true);
		} return(false);
	}
	
	
}

