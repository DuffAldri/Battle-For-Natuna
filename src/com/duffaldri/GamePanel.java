package com.duffaldri;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
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
	private Background bg;
	ArrayList<PlayerBullet> playerBulletList = new ArrayList<PlayerBullet>();
	ArrayList<EnemyBullet> enemyBulletList = new ArrayList<EnemyBullet>();
	ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	int[] level = new int[]{5, 10, 15};
	private int enemyCounter;
	private Score score;
	private HealthPoint hp;
	private int areaWidth;
	private int areaHeight;
	private int radius = 27;
	boolean isHold;
	Robot robot;
	
	public GamePanel(int width, int height) {
		this.areaWidth = width;
		this.areaHeight = height;
		this.setPreferredSize(new Dimension(areaWidth, areaHeight));
		int x = width/2 + radius/2;
		int y = height - 2 * radius;
		this.isHold = false;
		player = new Player(x, y, Color.BLUE);
		bg = new Background(0,0, width, height, Color.BLACK);
		score = new Score();
		hp = new HealthPoint();

		try {
			this.robot = new Robot();
			robot.mouseMove(x, y);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		this.setCursor(this.getToolkit().createCustomCursor(
                   new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),
                   new Point(),
                   null ) );
		
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
					for(int i = 0; i < playerBulletList.size(); i++) {
						boolean flag = false;
						System.out.println("Checking bullet. Bullet: " + i);
						Bullet b = playerBulletList.get(i);
						if(b.y + 40 < 0) {
							playerBulletList.remove(i);
							System.out.println("Bullet removed");
						}
						else {
							for(int j = 0; j < enemyList.size() && flag == false; j++) {
								System.out.println("Checking hit");
								Enemy e = enemyList.get(j);
								
								if(e.bulletHit(playerBulletList.get(i))) {
									enemyList.remove(j);
									playerBulletList.remove(i);
									System.out.println("Enemy Hit");
									flag = true;
									score.addValue();
									enemyCounter--;
									hp.increaseHP(2);
								}
							}	
						}
						b.move();
						
					}			
				
					bg.moveBG();
						
					if(time >= randTimer && enemyCounter < level[0]) {
						enemyList.add(new Enemy(areaWidth, Color.red));
						time = 0;
						randTimer = rand.nextInt(30 + 1) + 10;
						enemyCounter++;
					}
						
					for(int i = 0; i < enemyList.size(); i++) {
						Enemy e = enemyList.get(i);
						e.move();
						e.shootTimer++;
						if(e.y > areaHeight) {
							enemyList.remove(i);
							hp.decreaseHP(20);
							System.out.println("Enemy removed");
							enemyCounter--;
						}		
						if(e.shootTimer >= 70) {
							enemyBulletList.add(new EnemyBullet(e.x + e.width/2 - 2, e.y + e.height/2 , -15));
							e.shootTimer = 0;
						}
					}	
					
					for(int i = 0; i < enemyBulletList.size(); i++) {
						Bullet b = enemyBulletList.get(i);
						System.out.println(enemyBulletList.size());
						if(b.y > areaHeight) {
							enemyBulletList.remove(i);
							System.out.println("Enemy bullet removed");
						}
						System.out.println(enemyBulletList.size());
						if(player.bulletHit(b)) {
							hp.decreaseHP(10);
							enemyBulletList.remove(i);
						}
						b.move();
					}
					
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
		
		this.playerBulletList.add(new PlayerBullet(x, y, 25));
		
		
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
		bg.draw(g);
		player.draw(g);
		
		for(Bullet b : playerBulletList) {
			b.draw(g);
		}
		
		for(Bullet b : enemyBulletList) {
			b.draw(g);
		}
		
		for(Enemy e : enemyList) {
			e.draw(g);
		}
		
		hp.draw(g);
		score.draw(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		player.x = x;
		player.y = y;
		player.minX = x - player.width/2;
		player.minY = y - player.height/2;
			
		System.out.println(x + " " + y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		player.x = x;
		player.y = y;
		player.minX = x - player.width/2;
		player.minY = y - player.height/2;
		
		System.out.println(x + " " + y);
	}
}
