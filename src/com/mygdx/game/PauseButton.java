package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PauseButton {
	private Sprite sprite;

	public PauseButton(){
		sprite = new Sprite(new Texture(Gdx.files.internal("res/PauseButton.png")));
		sprite.setPosition(762, 442);
	}

	public void draw(SpriteBatch batch){
		sprite.draw(batch);
	}
}
