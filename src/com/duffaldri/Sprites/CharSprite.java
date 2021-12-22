package com.duffaldri.Sprites;

import java.awt.Color;
import java.awt.image.BufferedImage;
import com.duffaldri.Audio.*;

public class CharSprite {
	protected int x, y;
	protected int width, height;
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	Color color;
	BufferedImage image;
	
	protected int minX, minY;
	
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
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}
}

