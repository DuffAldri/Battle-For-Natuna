package com.duffaldri;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HealthPoint {
	int value;
	String text;
	Font font;
	
	public HealthPoint() {
		font = new Font("Verdana", Font.BOLD, 20);
		this.value = 100;
		this.text = "HP = ";
	}
	
	public int getValue() {
		return value;
	}

	public void draw (Graphics g) {
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(text + value, 5, 60);
	}
	
	public void increaseHP(int value) {
		this.value += value;
	}
	
	public void decreaseHP(int value) {
		this.value -= value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
