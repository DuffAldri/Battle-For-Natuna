package com.duffaldri;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class Enemy extends CharSprite {
	int speed;
	boolean hit;
	int shootTimer;
	
	public Enemy(int panelWidth, Color color) {
		super(color);
		Random rand = new Random();
		this.x = rand.nextInt((panelWidth - 40)/30) * 30 + 10;
		this.y = 0 - 96;
		this.speed = rand.nextInt(3 - 1 + 1) + 1;
		
		this.minX = x;
		this.minY = y;
		
		this.hit = false;
		this.shootTimer = 0;
		
		 try {                
	          image = ImageIO.read(new File("resource/KapalEnemy.png"));
		 } catch (IOException ex) {
	            // handle exception...
		 }
		 
	}
	
	public void draw (Graphics g) {
//		g.setColor(color);
//		g.drawRect(x, y, width, height);
		g.drawImage(image, x, y, width, height, null);
	}
	
	public void move() {
		this.y += speed;
		this.minY = this.y;
	}
	

}
