package com.duffaldri;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Highscore {
	int value;
	String text;
	Font font;
	
	public Highscore(int value) {
		font = new Font("Minecraft", Font.BOLD, 20);
		this.value = value;
		this.text = "Highscore = ";
	}
	
	public void setHighscore(int v) {
		if(v > this.value) this.value = v;
	}
	
	public int getHighscore() {
		return value;
	}

	public void draw (Graphics g) {
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(text + value, 5, 25);
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
