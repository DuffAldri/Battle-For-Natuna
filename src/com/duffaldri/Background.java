package com.duffaldri;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class Background {
	int minX;
	int maxX;
	int minY;
	int maxY;
	float x, y;
	private Color colorFilled;
	BufferedImage image;
	
	public Background(int x, int y, int width, int height,
			Color colorfilled) {
		this.minX = x;
		this.minY = y;
		this.maxX = x + width - 1;
		this.maxY = y + height -1;
		this.y = this.minY - 600;
		
		try {                
		     image = ImageIO.read(new File("resource/bg-laut.png"));
		} catch (IOException ex) {
		       // handle exception...
		}
	}
	
	public void moveBG() {
		this.y += 0.5;
		if(this.y == 0) {
			this.y = this.minY - 600;
		}
	}
	
//	public void set(int x, int y, int width, int height) {
//		minX = x;
//		minY = y;
//		maxX = x + width - 1;
//		maxY = y + height -1;
//	}
	
	public void draw(Graphics g) {
		g.setColor(colorFilled);
//		g.fillRect(minX, minY, maxX - minX -1 , maxY - minY -1);
		g.drawImage(image, 0, (int) y, null);
	}
}
