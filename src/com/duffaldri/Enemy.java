package com.duffaldri;

import java.awt.*;
import java.util.Random;

public class Enemy {
	int x, y;
	int width, height;
	private Color color;
	int speed;
	boolean hit;
	
	public Enemy(int panelWidth, Color color) {
		Random rand = new Random();
		this.x = rand.nextInt(panelWidth/20) * 20 + 20;
		this.y = 0 - 96;
		this.speed = rand.nextInt(3 - 1 + 1) + 1;
		
		this.width = 27;
		this.height = 96;
		this.color = color;
		this.hit = false;
	}
	
	public void draw (Graphics g) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
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
