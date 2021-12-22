package com.duffaldri.Sprites;

import java.awt.Color;

public class EnemyBullet extends Bullet {

	public EnemyBullet(int x, int y, int speed) {
		super(x, y, speed);
		this.color = Color.YELLOW;
	}

}
