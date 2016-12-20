package com.mygdx.game.musicplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HpBar extends HitPoint{
	private Sprite sprite;
	private float x;
	private float y;

	public HpBar(float x, float y){
		super();
		this.x = x + 6;
		this.y = y + 128;
		sprite = new Sprite(new Texture(Gdx.files.internal("res/HPbar.png")));
		sprite.setScale(3f);
		sprite.setPosition(this.x, this.y);
	}

	public void drawFrame(SpriteBatch batch){
		sprite.draw(batch);
	}

	public void drawBar(ShapeRenderer renderer){
		if(hp>=0){
			renderer.setColor(0,1,0,1);
			renderer.rect(60, 460, hp * 1.5f, 6);
		}
	}

	public float getX(){
		return this.x;
	}

	public float getY(){
		return this.y;
	}
}
