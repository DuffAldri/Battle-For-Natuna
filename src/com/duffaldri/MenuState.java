package com.duffaldri;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
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
							play;
	private ArrayList<Button> buttonList = new ArrayList<Button>();
//	private JButton playButton,
//					settingButton;
	
	
	public MenuState(StateManager sm) {
		this.sm = sm;
		
		bg = new Background(0, 0, areaWidth * 2, areaHeight, Color.BLACK);
		try {
			logo = ImageIO.read(new File("resource/logo.png"));
			play = ImageIO.read(new File("resource/button-start.png"));
//			this.playButton.setIcon(new ImageIcon(play));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		buttonList.add(new Button(play, areaWidth/2 - (144 * 3/4) + 2, 
				areaHeight/2 + 70, 288 * 3 / 4, 135 * 3 / 4, 1));
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		bg.draw(g);
		g.drawImage(logo, areaWidth/2 - 150, areaHeight/2 - 260, 300, 300, null);
		for(Button b : buttonList) {
			b.draw(g);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		bg.moveBG();
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		for(Button b : buttonList) {
			b.mouseClicked(x, y, sm);
			
		}
				
	}
}
