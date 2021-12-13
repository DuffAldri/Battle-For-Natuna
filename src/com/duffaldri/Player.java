package com.duffaldri;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	int x, y;
	int width, height;
	int hp;
	private Color color;
	BufferedImage image;
	
	public Player(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.width = 27;
		this.height = 96;
		this.color = color;
		this.hp = 100;
		
		try {                
	          image = ImageIO.read(new File("resource/Kapal.png"));
		} catch (IOException ex) {
	            // handle exception...
		}
	}
	
	
	public void draw (Graphics g) {
		g.setColor(color);
		g.drawRect(x - width/2, y - height/2, width, height);
		g.drawImage(image, x - width/2, y - height/2, width, height, null);
	}
	
//	public void collide (BallArea box) {
//		float ballMinX = box.minX + radius;
//		float ballMinY = box.minY + radius;
//		float ballMaxX = box.maxX - radius;
//		float ballMaxY = box.maxY - radius;
//		
//		x += speedX;
//		y += speedY;
//		
//		if (x < ballMinX) {
//			speedX = -speedX;
//			x = ballMinX;
//		} else if (x > ballMaxX) {
//			speedX = -speedX;
//			x = ballMaxX;
//		}
//		
//		if (y < ballMinY) {
//			speedY = -speedY;
//			y = ballMinY;
//		} else if (y > ballMaxY) {
//			speedY = - speedY;
//			y = ballMaxY;
//		}
//	}
}
