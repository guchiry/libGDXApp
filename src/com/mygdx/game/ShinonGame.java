package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class ShinonGame extends Hero{

	public ShinonGame(Vector2 position){
		super(position);
		img = new Texture(Gdx.files.internal("res/sinon2.png"));
		initImg();
		setSprite();
	}

}