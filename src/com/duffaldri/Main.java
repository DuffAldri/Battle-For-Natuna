package com.duffaldri;

import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				GamePanel panel = new GamePanel(1200, 600);
				// TODO Auto-generated method stub
				JFrame frame = new JFrame("Battle For Natuna");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(panel);
			    frame.getContentPane().add(panel.bgLabel);
				frame.pack();
				frame.setVisible(true);
				frame.setResizable(false);
			}			
		});
	}

}
