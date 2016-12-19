package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PauseButton {
	private Sprite sprite;
	private float x;
	private float y;

	public PauseButton(float x, float y){
		sprite = new Sprite(new Texture(Gdx.files.internal("res/PauseButton.png")));
		this.x = x + 682;
		this.y = y + 112;
		sprite.setPosition(this.x, this.y);
	}

	public void draw(SpriteBatch batch){
		sprite.draw(batch);
	}

	public float getX(){
		return this.x;
	}

	public float getY(){
		return this.y;
	}
}
