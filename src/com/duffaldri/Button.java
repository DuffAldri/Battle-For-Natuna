package com.duffaldri;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class Button {
	BufferedImage image;
	int x, y;
	int height, width;
	int state;
	
	Audio sfx;
	
	public Button(BufferedImage image, int x, int y, 
			int width, int height, int state) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.height = height;
		this.width = width;
		this.state = state;
		sfx = new Audio("button.wav");
	}
	
	public void mouseClicked(int x, int y, StateManager sm) {
		if(x >= this.x && x <= this.x + this.width
				&& y >= this.y && y <= this.y + this.width) 
			sm.setState(state);
	}
	
	public int mouseClicked(int x, int y) {
		if(x >= this.x && x <= this.x + this.width
				&& y >= this.y && y <= this.y + this.width) {
			sfx.play();
			return this.state;
//			sm.setState(state);
		} else return -1;
	}
	
	public void setImage(BufferedImage image, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.height = height;
		this.width = width;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}
}
