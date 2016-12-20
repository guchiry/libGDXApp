package com.mygdx.game.musicplay;

public class HitPoint {
	protected int hp;

	public HitPoint(){
		hp = 100;
	}

	public int getHp(){
		return this.hp;
	}

	public void decreaseHp() {
		this.hp -= 10;
	}
}
