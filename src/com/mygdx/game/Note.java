package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Note {
	private Vector2 position;
	private float speed;
	private Sprite sprite;

	public Note(Vector2 position){
		this.position = position;
		this.speed = Setting.NOTES_SPEED;
		Texture texture = new Texture(Gdx.files.internal("res/" + "kaede2.png"));
		sprite = new Sprite(new TextureRegion(texture,16,0,16,16));
		sprite.setScale(3f);
	}

	public Vector2 getPosition(){
		return position;
	}

	public Sprite getSprite(){
		return sprite;
	}

	public void movePositionX(){
		this.position.x -= this.speed;
	}
}
