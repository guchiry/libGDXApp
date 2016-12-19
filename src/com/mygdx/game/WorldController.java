package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Hero;
import com.mygdx.game.Hero.Direction;
import com.mygdx.game.World;

public class WorldController {
	private World world;
	float time = 0;

	private float fadeInTime = 0;
	private float fadeEndTime = 0;
	private boolean fadeInOn = false;
	private boolean fadeOutOn = false;

	public WorldController(World world) {
		this.world = world;
	}

	/** The main update method **/
	public void update(float delta) {
		time += delta;
		fadeOutControll(0,2,delta);
		moveControll(3,5,Direction.FRONT,1);
		moveControll(5,8,Direction.RIGHT,0);
		feelingControll(8,11,1);
		jumpControll(12,1);
		tackleControll(13,Direction.RIGHT,1);

	}

	public void fadeInControll(float startTime, float endTime, float delta){
		if(time >= startTime && endTime > time){
			fadeInOn = true;
			fadeInTime+=delta;
			fadeEndTime = endTime;
		}else{
			fadeInTime = 0;
			fadeEndTime = 0;
			fadeInOn = false;
		}
	}

	public void fadeOutControll(float startTime, float endTime, float delta){
		if(time >= startTime && endTime > time){
			fadeOutOn = true;
			fadeInTime+=delta;
			fadeEndTime = endTime;
		}else{
			fadeInTime = 0;
			fadeEndTime = 0;
			fadeOutOn = false;
		}
	}

	public void moveControll(float startTime ,float endTime,Direction dir,int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		hero.setSprite();
		if(time >= startTime && endTime > time){
			world.move(hero, dir);
		}
	}
	public void feelingControll(float startTime ,float endTime,int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		if(time >= startTime && endTime > time){
			hero.setState(hero.state.FEELING);
		}
	}

	public void jumpControll(float startTime,int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		if(time >= startTime && startTime+0.643 > time){
			hero.setState(hero.state.JUMP);
			world.jump(hero);
		}
	}

	public void tackleControll(float startTime ,Direction dir,int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		hero.setSprite();
		if(time >= startTime && startTime+0.2 > time){
			world.tackle(hero, dir);
		}
	}

	public float getTime(){
		return time;
	}

	public float getFadeInTime(){
		return fadeInTime;
	}

	public boolean isFadeInOn(){
		return fadeInOn;
	}

	public boolean isFadeOutOn(){
		return fadeOutOn;
	}

	public float getFadeEndTime() {
		return fadeEndTime;
	}

}
