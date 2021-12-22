package com.duffaldri;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	int value;
	String text;
	Font font;
	
	public Score() {
		font = new Font("Minecraft", Font.BOLD, 20);
		this.value = 0;
		this.text = "Score = ";
	}
	
	public int getValue() {
		return value;
	}

	public void draw (Graphics g) {
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(text + value, 5, 60);
	}
	
	public void addValue() {
		this.value++;
		System.out.println("Score  " + this.value);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
