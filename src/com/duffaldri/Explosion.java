package com.duffaldri;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Explosion {
	int x, y;
	Color color;
	BufferedImage[] image;
	int counter;
	
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
}
