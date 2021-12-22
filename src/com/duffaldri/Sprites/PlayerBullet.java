package com.duffaldri.Sprites;

import java.awt.Color;

public class PlayerBullet extends Bullet {

	public PlayerBullet(int x, int y, int speed) {
		super(x, y, speed);
		this.color = Color.red;
	}

}
