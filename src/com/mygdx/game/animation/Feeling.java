package com.mygdx.game.animation;

import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Feeling {
//	private Array<Feeling> feelTypeList = new Array<Feeling>();
	public static final float SIZE = 1f;
	Vector2 	position = new Vector2();
	Hero hero;
	Texture game2Icon;
	Texture gameYIcon;
	Texture gameBIcon;
	Texture exclamateIcon;
	Texture enemyIcon;
	Texture okIcon;
	Texture surpriseIcon;
	Texture silenceIcon;
	Texture cryIcon;
	Texture damageIcon;

	public Feeling(Vector2 pos, Hero hero) {
		this.position = pos;
		this.hero = hero;

		game2Icon = new Texture(Gdx.files.internal("res/controller2.png"));
		gameYIcon = new Texture(Gdx.files.internal("res/controller.kaede.png"));
		gameBIcon = new Texture(Gdx.files.internal("res/controller.sinon.png"));
		exclamateIcon = new Texture(Gdx.files.internal("res/onpu.png"));
		enemyIcon = new Texture(Gdx.files.internal("res/Goblin.png"));
		okIcon = new Texture(Gdx.files.internal("res/maru.png"));
		surpriseIcon = new Texture(Gdx.files.internal("res/odoroki.png"));
		silenceIcon = new Texture(Gdx.files.internal("res/mugon.png"));
		cryIcon = new Texture(Gdx.files.internal("res/namida.png"));
		damageIcon = new Texture(Gdx.files.internal("res/damage.png"));

	}
	public Vector2 getPosition() {
		return position;
	}

	public Texture getFeelIcon(){
		if(hero.feelType == Hero.FeelType.GAME2) return game2Icon;
		if(hero.feelType == Hero.FeelType.GAMEYELLOW) return gameYIcon;
		if(hero.feelType == Hero.FeelType.GAMEBLUE) return gameBIcon;
		if(hero.feelType == Hero.FeelType.EXCLAMATION) return exclamateIcon;
		if(hero.feelType == Hero.FeelType.ENEMY) return enemyIcon;
		if(hero.feelType == Hero.FeelType.OK) return okIcon;
		if(hero.feelType == Hero.FeelType.SURPRISE) return surpriseIcon;
		if(hero.feelType == Hero.FeelType.SILENCE) return silenceIcon;
		if(hero.feelType == Hero.FeelType.CRY) return cryIcon;
		if(hero.feelType == Hero.FeelType.DAMAGE) return damageIcon;
		return null;
	}
	public void setPosition(Vector2 position){
		this.position = position;
	}

}
