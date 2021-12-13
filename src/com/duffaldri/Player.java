package com.duffaldri;

import java.awt.*;

public class Player {
	int x, y;
	int width, height;
	private Color color;
	
	public Player(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.width = 27;
		this.height = 96;
		this.color = color;
	}
	
	public void draw (Graphics g) {
		g.setColor(color);
		g.drawRect(x - width/2, y - height/2, width, height);
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
