package com.duffaldri;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class Enemy {
	int x, y;
	int width, height;
	private Color color;
	int speed;
	boolean hit;
	BufferedImage image;
	
	public Enemy(int panelWidth, Color color) {
		Random rand = new Random();
		this.x = rand.nextInt((panelWidth - 40)/30) * 30 + 10;
		this.y = 0 - 96;
		this.speed = rand.nextInt(3 - 1 + 1) + 1;
		
		this.width = 27;
		this.height = 96;
		this.color = color;
		this.hit = false;
		
		 try {                
	          image = ImageIO.read(new File("resource/KapalEnemy.png"));
		 } catch (IOException ex) {
	            // handle exception...
		 }
		 
		 
	}
	
	public void draw (Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
		g.drawImage(image, x, y, width, height, null);
	}
	
	public void move() {
		this.y += speed;
	}
	
	public void collide (Bullet bullet) {
		int enemyMinX = this.x;
		int enemyMinY = this.y + height;
		int enemyMaxX = this.x + width;
		
		if (((bullet.x > enemyMinX && bullet.x < enemyMaxX) 
				|| (bullet.x + bullet.width > enemyMinX && bullet.x + bullet.width < enemyMaxX)) 
				&& (bullet.y <= enemyMinY)) {
			hit = true;
		} 
	}
}
