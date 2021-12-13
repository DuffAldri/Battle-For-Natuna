package com.duffaldri;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame("Battle For Natuna");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new GamePanel(1200, 600));
				frame.pack();
				frame.setVisible(true);
			}
			
		});
	}

}
