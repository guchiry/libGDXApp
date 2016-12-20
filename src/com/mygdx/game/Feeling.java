package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Hero;
//import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Feeling {
//	private Array<Feeling> feelTypeList = new Array<Feeling>();
	public static final float SIZE = 1f;
	Vector2 	position = new Vector2();
	Hero hero;
	Texture feelIconA;
	Texture feelIconB;
	Texture feelIconC;
	Texture feelIconD;
	Texture feelIconE;

	public Feeling(Vector2 pos, Hero hero) {
		this.position = pos;
		this.hero = hero;

		feelIconA = new Texture(Gdx.files.internal("res/kaede2.png"));
		feelIconB = new Texture(Gdx.files.internal("res/kaede5.png"));
		feelIconC = new Texture(Gdx.files.internal("res/sinon.png"));
		feelIconD = new Texture(Gdx.files.internal("res/sinon2.png"));
		feelIconE = new Texture(Gdx.files.internal("res/visyunu.png"));

	}
	public Vector2 getPosition() {
		return position;
	}

	public Texture getFeelIcon(){
		if(hero.feelType == Hero.FeelType.A) return feelIconA;
		if(hero.feelType == Hero.FeelType.B) return feelIconB;
		if(hero.feelType == Hero.FeelType.C) return feelIconC;
		if(hero.feelType == Hero.FeelType.D) return feelIconD;
		return null;
	}
}
