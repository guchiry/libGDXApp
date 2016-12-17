package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Kaede {
	public enum State{
		IDLE, WALKING
	}

	static final float SPEED = 1f;
	static final float SIZE = 1f;

	private Vector2 position = new Vector2();
	Rectangle bounds = new Rectangle();
	Texture img;
	TextureRegion[] split;
	State state = State.IDLE;

	public Kaede(Vector2 position){
		this.position = position;
		this.bounds.x = SIZE;
		this.bounds.y = SIZE;
		img = new Texture(Gdx.files.internal("res/" + "kaede2.png"));
		split = new TextureRegion(img).split(16, 16)[0];
	}

	public Vector2 getPosition(){
		return position;
	}

	public Rectangle getBounds(){
		return bounds;
	}

	public TextureRegion getKaedeSplit(){
		return split[1];
	}
}
