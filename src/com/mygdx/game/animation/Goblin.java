package com.mygdx.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.animation.Hero.Direction;

public class Goblin extends Hero{

	Texture goblin;

	public Goblin(Vector2 position){
		super(position);
		goblin = new Texture(Gdx.files.internal("res/Goblin.png"));
		sprite = new Sprite(goblin);
	}

	public Sprite getGoblin(){
		sprite = new Sprite(goblin);
		return sprite;
	}
}