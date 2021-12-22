package com.duffaldri;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public abstract class State {
	
	StateManager sm;
	
	public abstract void update();
	public abstract void draw(Graphics g);
	public int areaWidth = 1200;
	public int areaHeight = 600;
	
	public void sfxInit() {}
	
	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	
	public void mouseClicked(MouseEvent e) {}

	
	public void mousePressed(MouseEvent e) {}

	
	public void mouseReleased(MouseEvent e) {}

	
	public void mouseEntered(MouseEvent e) {}

	
	public void mouseExited(MouseEvent e) {}
}
