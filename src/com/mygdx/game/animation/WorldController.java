package com.mygdx.game.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.animation.Hero.FeelType;
import com.mygdx.game.animation.Hero.Direction;

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
		//カエデ、シノン、リアル
		fadeOutControll(0,2,delta,0);
		rotateControll(3,4,Direction.RIGHT,0);
		rotateControll(3,4,Direction.LEFT,1);
		feelingControll(4,8,FeelType.A,1);//ゲーム*2
		jumpControll(4,1);
		feelingControll(6,7,FeelType.B,0);//！
		jumpControll(6,0);
		moveControll(7,8,Direction.LEFT,1);
		feelingControll(8,13,FeelType.C,0);//ゲーム*1
		feelingControll(8,13,FeelType.D,1);//ゲーム*1
		rotateControll(10,11,Direction.FRONT,0);
		rotateControll(10,11,Direction.FRONT,1);
		fadeInControll(11,13,delta,1);
		if(time >= 13 && 15 > time){
			world.getDispHeroList().removeRange(0, 1);
			world.getDispHeroList().add(new KaedeGame(new Vector2(310, 150)));
			world.getDispHeroList().add(new ShinonGame(new Vector2(400, 150)));
		}
		//カエデ、シノン、ゲーム内
		fadeOutControll(13,15,delta,2);
		rotateControll(15,16,Direction.RIGHT,0);
		rotateControll(15,16,Direction.LEFT,1);
		feelingControll(16,19,FeelType.B,1);//敵
		feelingControll(17,19,FeelType.B,0);//〇
		jumpControll(17,0);
		moveControll(20,25,Direction.RIGHT,0);
		moveControll(20,25,Direction.RIGHT,1);
		fadeInControll(23,25,delta,3);
		if(time >= 25 && 27 > time){
			world.getDispHeroList().removeRange(0, 1);
			world.getDispHeroList().add(new KaedeGame(new Vector2(360, 70)));
			world.getDispHeroList().add(new ShinonGame(new Vector2(360, 230)));
//			world.getDispHeroList().add(new Goblin(new Vector2(360, 150)));
		}
		rotateControll(25,27,Direction.BACK,0);
		//カエデ、シノン、ゴブリン、ゲーム内戦闘
		fadeOutControll(25,27,delta,4);
		tackleControll(27,Direction.BACK,0);
		tackleControll(28,Direction.FRONT,1);
		fadeInControll(28,30,delta,5);
		if(time >= 30 && 32 > time){
			world.getDispHeroList().removeRange(0, 1);
			world.getDispHeroList().add(new KaedeGame(new Vector2(310, 150)));
			world.getDispHeroList().add(new VisnuGame(new Vector2(440, 150)));
		}
		rotateControll(30,32,Direction.RIGHT,0);
		rotateControll(30,32,Direction.LEFT,1);
		//カエデ、ヴィシュヌ、ゲーム内
		fadeOutControll(30,32,delta,6);
		moveControll(32,33,Direction.LEFT,1);
		jumpControll(33,1);
		feelingControll(34,35,FeelType.B,0);//〇
		moveControll(35,40,Direction.RIGHT,0);
		moveControll(35,40,Direction.RIGHT,1);
		fadeInControll(39,41,delta,7);
		if(time >= 41 && 43 > time){
			world.getDispHeroList().removeRange(0, 1);
			world.getDispHeroList().add(new KaedeGame(new Vector2(360, 70)));
			world.getDispHeroList().add(new ShinonGame(new Vector2(360, 150)));
			world.getDispHeroList().add(new VisnuGame(new Vector2(360, 230)));
		}
/*
		rotateControll(41,43,Direction.BACK,2);
		//カエデ、ヴィシュヌ、シノン、ゲーム内戦闘
		fadeOutControll(41,43,delta,8);
		feelingControll(44,46,FeelType.B,0);//驚き
		feelingControll(44,46,FeelType.B,2);//驚き
		feelingControll(47,48,FeelType.B,1);//無言
		tackleControll(49,Direction.FRONT,1);
		feelingControll(50,51,FeelType.B,2);//-10p
		feelingControll(51,52,FeelType.C,0);//驚き
		feelingControll(51,52,FeelType.C,2);//驚き
		feelingControll(52,53,FeelType.A,2);//泣き
		jumpControll(52,2);
		feelingControll(53,54,FeelType.B,1);//無言
		if(time >= 52){
			world.getDispHeroList().removeRange(1, 1);
		}
*/
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
		hero.setFeelingFlag(hero.feelingFlag.ON);
			hero.setFeelType(feelType);
		}
	}

	public void jumpControll(float startTime,int listNumber){
		Hero hero = world.getDispHeroList().get(listNumber);
		if(time >= startTime && startTime+0.642 > time){
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
