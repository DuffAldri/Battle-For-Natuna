package com.duffaldri;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	int x, y;
	int speed;
	int width, height;
	Color color;
	
	Audio sfx;
	
	public Bullet(int x, int y, int speed) {
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.width = 6;
		this.height = 15;
		sfx = new Audio("shoot-2.wav");
		sfx.play();
	}
	
	public void setColor (Color color) {
		this.color = color;
	}
	public void draw (Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	public void move() {
		this.y -= speed;
	}
}
