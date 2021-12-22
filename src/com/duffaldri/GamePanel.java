package com.duffaldri;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final int REFRESH_RATE = 30;
	private static final long serialVersionUID = 1L;
	private int areaWidth;
	private int areaHeight;
	Robot robot;
	
	private StateManager sm;
	
	public GamePanel(int width, int height) {
		this.areaWidth = width;
		this.areaHeight = height;
		this.setPreferredSize(new Dimension(areaWidth, areaHeight));
//		int x = width/2 + radius/2;
//		int y = height - 2 * radius;
		
		sm = new StateManager();
		
//		this.setCursor(this.getToolkit().createCustomCursor(
//                   new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),
//                   new Point(),
//                   null ) );
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setFocusable(true);
		startThread();
	}
	
	public void startThread() {
		Thread gameThread = new Thread() {
			public void run() {
				while(true) {
					sm.update();
					repaint();
					try {
						Thread.sleep(1000 / REFRESH_RATE);
					} catch (InterruptedException ex) {}
				}
			
			}
		};
		gameThread.start();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		sm.draw(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		sm.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		sm.mouseMoved(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		sm.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		sm.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		sm.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		sm.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		sm.mouseExited(e);
	}

}
