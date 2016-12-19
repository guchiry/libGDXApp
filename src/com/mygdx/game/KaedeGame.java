package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class KaedeGame extends Hero{

	public KaedeGame(Vector2 position){
		super(position);
		img = new Texture(Gdx.files.internal("res/kaede2.png"));
		initImg();
		setSprite();

	}

}