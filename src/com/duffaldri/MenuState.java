package com.duffaldri;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MenuState extends State {
	private Background bg;
	private BufferedImage 	logo,
							setting,
							play;
	private JButton playButton,
					settingButton;
	
	
	public MenuState() {
		bg = new Background(0, 0, areaWidth, areaHeight, Color.BLACK);
		try {
			logo = ImageIO.read(new File("resource/logo.png"));
			play = ImageIO.read(new File("resource/button-start.png"));
			this.playButton.setIcon(new ImageIcon(play));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		bg.draw(g);
		g.drawImage(logo, areaWidth/2 - 150, areaHeight/2 - 260, 300, 300, null);
		g.drawImage(play, areaWidth/2 - (144 * 3/4) + 2, areaHeight/2 + 70, 288 * 3 / 4, 135 * 3 / 4, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
