package com.mygdx.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Goblin extends Hero{

	Texture goblin;

	public Goblin(Vector2 position){
		super(position);
		goblin = new Texture(Gdx.files.internal("res/Goblin.png"));
//		initImg();
//		setSprite();
		getGoblin();
	}

	public Sprite getGoblin(){
		sprite = new Sprite(goblin);
	return sprite;
	}
}