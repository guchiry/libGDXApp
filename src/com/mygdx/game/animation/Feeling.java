package com.mygdx.game.animation;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Feeling {
	public static final float SIZE = 1f;
	Vector2 	position = new Vector2();
	Texture img2;

	public Feeling(Vector2 pos) {
		this.position = pos;
		img2 = new Texture(Gdx.files.internal("res/kaede2.png"));
	}
	public Vector2 getPosition() {
		return position;
	}
	public Texture getFeeling(){
		return img2;
	}
}
