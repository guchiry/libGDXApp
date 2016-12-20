package com.mygdx.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class KaedeReal extends Hero{

	public KaedeReal(Vector2 position){
		super(position);
		img = new Texture(Gdx.files.internal("res/kaede5.png"));
		initImg();
		setSprite();
	}

}
