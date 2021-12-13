package com.duffaldri;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int REFRESH_RATE = 30;
	private Player player;
	private BallArea box;
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private Score score;
	private int areaWidth;
	private int areaHeight;
	private int radius = 27;
	boolean isHold;
	
	public GamePanel(int width, int height) {
		this.areaWidth = width;
		this.areaHeight = height;
		this.setPreferredSize(new Dimension(areaWidth, areaHeight));
		int x = width/2 + radius/2;
		int y = height - 2 * radius;
		this.isHold = false;
		
		player = new Player(x, y, Color.BLUE);
		box = new BallArea(0,0, width, height, Color.BLACK, Color.WHITE);
		score = new Score();
		
//		this.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent e) {
//				Component c = (Component) e.getSource();
//				Dimension dim = c.getSize();
//				areaWidth = dim.width;
//				areaHeight = dim.height;
//				box.set(0, 0, width, height);
//			}
//		});
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setFocusable(true);
		startThread();
	}

	public void startThread() {
		// TODO Auto-generated method stub
		Thread gameThread = new Thread() {
			public void run() {
				int randTimer = 20;
				int time = 0;
				Random rand = new Random();
				while (true) {
//					ball.move(box);
//					try {
						for(int i = 0; i < bulletList.size(); i++) {
							boolean flag = false;
							System.out.println("Checking bullet. Bullet: " + i);
							Bullet b = bulletList.get(i);
							b.move();
							if(b.y + 40 < 0) {
								bulletList.remove(i);
								System.out.println("Bullet removed");
							}
							else {
								for(int j = 0; j < enemyList.size() && flag == false; j++) {
									System.out.println("Checking hit");
									Enemy e = enemyList.get(j);
									e.collide(bulletList.get(i));
									if(e.hit) {
										enemyList.remove(j);
										bulletList.remove(i);
										System.out.println("Enemy Hit");
										flag = true;
										score.addValue();
									}
								}	
							}
							
						}
						
					if(randTimer == time) {
						enemyList.add(new Enemy(areaWidth, Color.red));
						time = 0;
						randTimer = rand.nextInt(30 + 1) + 10;
						
					}
						
					for(int i = 0; i < enemyList.size(); i++) {
						Enemy e = enemyList.get(i);
						e.move();
						if(e.y > areaHeight) {
							enemyList.remove(i);
							System.out.println("Enemy removed");
						}						
					}	
					
//					catch(Exception e) {
//						System.err.println("Terjadi exception collide dengan ball lain");						
//					}
					repaint();
					time++;
					try {
						Thread.sleep(1000 / REFRESH_RATE);
					} catch (InterruptedException ex) {}
				}
			}
		};
		gameThread.start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
		int x = e.getX() - 2;
		int y = e.getY();
//		
//		if (mouseX > ball.x - radius && mouseX < ball.x + radius &&
//				mouseY > ball.y - radius && mouseY < ball.y + radius) {
//			ball.speedX = ball.speedX >= 0 ? ball.speedX + 1 : ball.speedX - 1;
//			ball.speedY = ball.speedY >= 0 ? ball.speedY + 1 : ball.speedY - 1;
//			ball.speedX = -ball.speedX;
//			ball.speedY = -ball.speedY;
//			
//			score.addValue();
//			score.setText(String.format("Score = %d", score.getValue())); 	
//		}

		this.isHold = true;
		
		this.bulletList.add(new Bullet(x, y, this.radius, 25));
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.isHold = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		box.draw(g);
		player.draw(g);
		score.draw(g);
		
		for(Bullet b : bulletList) {
			b.draw(g);
		}
		
		for(Enemy e : enemyList) {
			e.draw(g);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		player.x = x;
		player.y = y;
			
		System.out.println(x + " " + y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
			player.x = x;
			player.y = y;
			
			System.out.println(x + " " + y);
	}
}
