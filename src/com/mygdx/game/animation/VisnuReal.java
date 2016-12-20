package com.mygdx.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class VisnuReal extends Hero{

	public VisnuReal(Vector2 position){
		super(position);
		img = new Texture(Gdx.files.internal("res/visyunu.png"));
		initImg();
		setSprite();
	}

}