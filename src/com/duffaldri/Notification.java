package com.duffaldri;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Notification {
	int x, y;
	int value;
	Color color;
	int counter;
	String string;
	Font font;
	
	public Notification (int x, int y, int value) {
		this.x = x + 20;
		this.y = y + 5;
		this.value = value;
		counter = 0;
		if(value > 0) {
			string = String.format("+%d", value);
			color = Color.decode("#1ea40d");
		} else {
			string = String.format("%d", value);
			color = Color.RED;
		}
		font = new Font("Minecraft", Font.BOLD, 20);
	}
	
	public void draw(Graphics g) {
		g.setFont(font);
		g.setColor(color);
		g.drawString(string, x, y);
		counter++;
	}
}
