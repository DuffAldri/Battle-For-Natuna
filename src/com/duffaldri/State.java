package com.duffaldri;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public interface State {
	
	public void update();
	
	public void draw(Graphics g);
	
	public void sfxInit();
	
	public void mouseDragged(MouseEvent e);

	public void mouseMoved(MouseEvent e);

	public void mouseClicked(MouseEvent e);

	public void mousePressed(MouseEvent e);

	public void mouseReleased(MouseEvent e);

	public void mouseEntered(MouseEvent e);

	public void mouseExited(MouseEvent e);
}
