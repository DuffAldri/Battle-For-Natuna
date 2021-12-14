package com.duffaldri;

import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class Button extends JButton {
	BufferedImage image;
	String buttonName;
	int height, width;
	
	public Button(String name, int height, int width, BufferedImage image) {
		this.image = image;
		this.buttonName = name;
		this.height = height;
		this.width = width;
	}
	
}
