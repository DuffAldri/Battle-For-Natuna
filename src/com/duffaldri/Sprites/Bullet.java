package com.duffaldri.Sprites;

import java.awt.Color;
import java.awt.Graphics;

import com.duffaldri.Audio.Audio;

public class Bullet {
	protected int x, y;
	protected int speed;
	protected int width, height;
	protected Color color;
	private Audio sfx;
	
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

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
}
