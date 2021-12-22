package com.duffaldri.Sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.duffaldri.Audio.Audio;

public class Explosion {
	private int x, y;
	Color color;
	BufferedImage[] image;
	private int counter;
	
	Audio sfx;
	
	public Explosion (int x, int y) {
		this.x = x;
		this.y = y;
		image = new BufferedImage[7];
		counter = 0;
		
		sfx = new Audio("explosion.wav");
		sfx.play();
		
		for(int i = 0; i < 7; i++) {
			try {                
				image[i] = ImageIO.read(new File(
						String.format("resource/explosion/"
								+ "explosion-%d.png", i)));
			} catch (IOException ex) {
			}
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(image[counter], x - 50, y - 50, 100, 100, null);
		counter++;
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

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
