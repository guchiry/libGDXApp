package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HpBar extends HitPoint{
	private Sprite sprite;

	public HpBar(){
		super();
		sprite = new Sprite(new Texture(Gdx.files.internal("res/HPbar.png")));
	}

	public void drawFrame(SpriteBatch batch){
		sprite.setScale(3f);
		sprite.setPosition(86, 576);
		sprite.draw(batch);
	}

	public void drawBar(ShapeRenderer renderer){
		if(hp>=0){
			renderer.setColor(0,1,0,1);
			renderer.rect(60, 460, hp * 1.5f, 6);
		}
	}
}
