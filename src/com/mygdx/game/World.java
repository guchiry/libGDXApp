package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class World {
	private Array<Hero> dispHeroList = new Array<Hero>();

	public float jumpTime;
	public float tackleTime;

	private ShapeRenderer shapeRenderer;
	private OrthographicCamera cam;

	public World(OrthographicCamera cam){
		createDemoWorld();
		this.cam = cam;
	}

	public void createDemoWorld(){
		dispHeroList.add(new KaedeReal(new Vector2(310, 150)));
		dispHeroList.add(new ShinonReal(new Vector2(440,150)));

		shapeRenderer = new ShapeRenderer();
	}

	public void move(Hero hero, Hero.Direction direction){
		float x = hero.getPosition().x;
		float y = hero.getPosition().y;

		hero.setDirection(direction);
		hero.setState(Hero.State.WALKING);
		if(direction == Hero.Direction.FRONT) hero.setPosition(new Vector2(x,y-1));
		if(direction == Hero.Direction.BACK) hero.setPosition(new Vector2(x,y+1));
		if(direction == Hero.Direction.LEFT) hero.setPosition(new Vector2(x-1,y));
		if(direction == Hero.Direction.RIGHT) hero.setPosition(new Vector2(x+1,y));
	}
	public void jump(Hero hero){
		float x = hero.getPosition().x;
		float y = hero.getPosition().y;

		hero.setState(Hero.State.JUMP);
		hero.setPosition(new Vector2(x,y+5*MathUtils.sin(jumpTime)));
	}
	public void tackle(Hero hero, Hero.Direction direction){
		float x = hero.getPosition().x;
		float y = hero.getPosition().y;

		hero.setDirection(direction);
		hero.setState(Hero.State.TACKLE);
		if(direction == Hero.Direction.FRONT) hero.setPosition(new Vector2(x,y-20*MathUtils.sin(tackleTime)));
		if(direction == Hero.Direction.BACK) hero.setPosition(new Vector2(x,y+20*MathUtils.sin(tackleTime)));
		if(direction == Hero.Direction.LEFT) hero.setPosition(new Vector2(x-20*MathUtils.sin(tackleTime),y));
		if(direction == Hero.Direction.RIGHT) hero.setPosition(new Vector2(x+20*MathUtils.sin(tackleTime),y));
	}

	public void fadeIn(float fadeInTime, float endTime){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_BLEND, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.setProjectionMatrix(cam.combined);
		shapeRenderer.begin(ShapeType.Filled);
		if(fadeInTime <= endTime){
			shapeRenderer.setColor(0,0,0,fadeInTime/endTime);
		}
		shapeRenderer.rect(0,0,800,480);
		shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	public void fadeOut(float fadeInTime, float endTime){
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_BLEND, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.setProjectionMatrix(cam.combined);
		shapeRenderer.begin(ShapeType.Filled);
		if(fadeInTime <= endTime){
			shapeRenderer.setColor(0,0,0,1-fadeInTime/endTime);
		}
		shapeRenderer.rect(0,0,800,480);
		shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}



	public Array<Hero> getDispHeroList() {
		return dispHeroList;
	}

}
