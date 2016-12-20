package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Hero;
import com.mygdx.game.Hero.Direction;
import com.mygdx.game.Hero.FeelType;
import com.mygdx.game.Feeling;
import com.mygdx.game.World;

public class WorldController {
	private World world;
	float time = 0;

	private float fadeInTime = 0;
	private float fadeEndTime = 0;
	private int fadeCount = 0;
	private boolean fadeInOn = false;
	private boolean fadeOutOn = false;

//	private Vector2 position = new Vector2();
//	private Hero hero(Vector2);

	public WorldController(World world) {
		this.world = world;
	}

	/** The main update method **/

	//最後の引数はHeroのlist
	//0:kaedereal
	//1:shinonreal
	public void update(float delta) {
		time += delta;
		fadeOutControll(0,2,delta,0);
		rotateControll(3,4,Direction.RIGHT,0);
		rotateControll(3,4,Direction.LEFT,1);
		feelingControll(4,8,FeelType.A,1);//ゲーム*2
		jumpControll(4,1);
		feelingControll(6,7,FeelType.B,0);//！
		jumpControll(6,0);
		moveControll(7,8,Direction.LEFT,1);
		feelingControll(8,10,FeelType.C,0);//ゲーム*1
		feelingControll(8,10,FeelType.D,1);//ゲーム*1
		rotateControll(10,11,Direction.FRONT,0);
		rotateControll(10,11,Direction.FRONT,1);
		fadeInControll(11,13,delta,1);
		if(time >= 13 && 15 > time){
			world.getDispHeroList().removeRange(0, 1);
			world.getDispHeroList().add(new KaedeGame(new Vector2(310, 150)));
			world.getDispHeroList().add(new ShinonGame(new Vector2(400, 150)));
		}
		fadeOutControll(13,15,delta,2);

//		tackleControll(13,Direction.RIGHT,1);
//		System.out.println(time);

	}

	public void fadeInControll(float startTime, float endTime, float delta, int count){
		if(count == fadeCount){
			if(time >= startTime && endTime > time){
				fadeInOn = true;
				fadeInTime+=delta;
				fadeEndTime = endTime - startTime;
			}else if(endTime < time){
				fadeInTime = 0;
				fadeEndTime = 0;
				fadeInOn = false;
				fadeCount++;
			}
		}
	}

	public void fadeOutControll(float startTime, float endTime, float delta, int count){
		if(count == fadeCount){
			if(time >= startTime && endTime > time){
				fadeOutOn = true;
				fadeInTime+=delta;
				fadeEndTime = endTime - startTime;
			}else if(endTime < time){
				fadeInTime = 0;
				fadeEndTime = 0;
				fadeOutOn = false;
				fadeCount++;
			}
		}
	}

	public void moveControll(float startTime ,float endTime,Direction dir,int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		hero.setSprite();
		if(time >= startTime && endTime > time){
			world.move(hero, dir);
		}
	}
	public void feelingControll(float startTime ,float endTime,FeelType feelType, int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		if(time >= startTime && endTime > time){
			hero.setState(hero.state.FEELING);
			hero.getFeeling();
			hero.setFeelType(feelType);
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
	public void rotateControll(float startTime,float endTime, Direction dir,int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		if(time >= startTime && endTime > time){
		hero.setDirection(dir);
		hero.setSprite();
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
