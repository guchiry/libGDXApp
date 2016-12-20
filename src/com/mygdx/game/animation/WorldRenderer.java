package com.mygdx.game.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private World world;
	private SpriteBatch batch;
	ShapeRenderer shapeRenderer = new ShapeRenderer();
	private WorldController controller;
	float stateTime = 0;
	boolean loop = true;

	private OrthographicCamera cam;

	public WorldRenderer(World world, OrthographicCamera cam){
		this.world = world;
		batch = new SpriteBatch();
		this.cam = cam;
		controller = new WorldController(world);
	}

	public void update(float delta){
		controller.update(delta);
		stateTime += delta;
		world.jumpTime += MathUtils.PI2*3*delta;
		world.tackleTime += MathUtils.PI2*5*delta;
	}

	public void draw(){
		batch.setProjectionMatrix(cam.combined);
		batch.begin();

		for(Hero hero : world.getDispHeroList()){
			drawHero(hero);
		}
		batch.end();

		if(controller.isFadeInOn()){
			world.fadeIn(controller.getFadeInTime(), controller.getFadeEndTime());
		}

		if(controller.isFadeOutOn()){
			world.fadeOut(controller.getFadeInTime(), controller.getFadeEndTime());
		}

	}

	public void render(float delta){
		update(delta);
		draw();
	}

	public void drawHero(Hero hero){
		Feeling feeling = hero.getFeeling();
		float x1 = hero.getPosition().x;
		float y1 = hero.getPosition().y;

		TextureRegion heroSprite = hero.getSprite();
		if(hero.getState().equals(Hero.State.WALKING)){
			heroSprite = hero.currentAnim().getKeyFrame(stateTime,loop);
		}
		if(hero.getState().equals(Hero.State.FEELING)){
			Texture feelingIcon = feeling.getFeelIcon();
			batch.draw(feelingIcon,x1,y1+64,64,64);
		}
		batch.draw(heroSprite,x1,y1,64,64);

		hero.setState(hero.state.IDLE);
	}

}
