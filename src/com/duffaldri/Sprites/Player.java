package com.duffaldri.Sprites;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends CharSprite {
	int hp;
	
	public Player(int x, int y, Color color) {
		super(color);
		this.x = x;
		this.y = y;
		this.hp = 100;
		
		this.minX = x - width/2;
		this.minY = y - height/2;
		
		try {                
	          image = ImageIO.read(new File("resource/Kapal.png"));
		} catch (IOException ex) {
	            // handle exception...
		}
	}
	
	public void draw (Graphics g) {
//		g.setColor(color);
//		g.drawRect(minX, minY, width, height);
		g.drawImage(image, minX, minY, width, height, null);
	}
	
	public boolean collide(Enemy enemy) {
		
		if (((enemy.x > minX && enemy.x < minX + width) 
					|| (enemy.x + enemy.width > minX && enemy.x + enemy.width < minX + width)) 
				&& ((enemy.y >= minY && enemy.y <= minY + height) 
					|| (enemy.y + enemy.height > minY && enemy.y + enemy.height < minY + height))) {
			return(true);
		} return(false);
	}
}
