package com.mygdx.game.animation;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.animation.Hero.Direction;
import com.mygdx.game.animation.Hero.FeelType;

public class WorldController {
	private World world;
	float time = 0;

	private float fadeInTime = 0;
	private float fadeEndTime = 0;
	private int fadeCount = 0;
	private boolean fadeInOn = false;
	private boolean fadeOutOn = false;

	KaedeGame kaede = new KaedeGame(new Vector2(310, 150));
	ShinonGame shinon = new ShinonGame(new Vector2(400, 150));

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
		feelingControll(4,8,FeelType.GAME2,1);//ゲーム*2
		jumpControll(4,1);
		feelingControll(5,7,FeelType.EXCLAMATION,0);//！
		jumpControll(5,0);
		moveControll(7,8,Direction.LEFT,1);
		feelingControll(8,13,FeelType.GAMEYELLOW,0);//ゲーム*1
		feelingControll(8,13,FeelType.GAMEBLUE,1);//ゲーム*1
		rotateControll(10,11,Direction.FRONT,0);
		rotateControll(10,11,Direction.FRONT,1);
		fadeInControll(11,13,delta,1);
		if(time >= 13 && 15 > time){
			world.getDispHeroList().clear();
			world.getDispHeroList().add(kaede);
			world.getDispHeroList().add(shinon);
		}
		//カエデ、シノン、ゲーム内
		fadeOutControll(13,15,delta,2);
		rotateControll(15,16,Direction.RIGHT,0);
		rotateControll(15,16,Direction.LEFT,1);
		feelingControll(16,18,FeelType.ENEMY,1);//敵
		feelingControll(17,18,FeelType.OK,0);//〇
		jumpControll(17,0);
		moveControll(19,24,Direction.RIGHT,0);
		moveControll(19,24,Direction.RIGHT,1);
		fadeInControll(22,24,delta,3);
		if(time >= 24 && 26 > time){
			world.getDispHeroList().clear();
			world.getDispHeroList().add(new Goblin(new Vector2(360, 120)));
			world.getDispHeroList().add(new KaedeGame(new Vector2(360, 20)));
			world.getDispHeroList().add(new ShinonGame(new Vector2(360, 250)));
		}
		rotateControll(24,26,Direction.BACK,1);
		//カエデ、シノン、ゴブリン、ゲーム内戦闘
		fadeOutControll(24,26,delta,4);
		tackleControll(27,Direction.BACK,1);
		feelingControll(28,29,FeelType.DAMAGE,0);//-10p
		tackleControll(29,Direction.FRONT,2);
		feelingControll(30,31,FeelType.DAMAGE,0);//-10p
		fadeInControll(32,34,delta,5);
		if(time >= 34 && 36 > time){
			world.getDispHeroList().clear();
			world.getDispHeroList().add(new KaedeGame(new Vector2(310, 150)));
			world.getDispHeroList().add(new VisnuGame(new Vector2(440, 150)));
		}
		rotateControll(34,36,Direction.RIGHT,0);
		rotateControll(34,36,Direction.LEFT,1);
		//カエデ、ヴィシュヌ、ゲーム内
		fadeOutControll(34,36,delta,6);
		moveControll(36,37,Direction.LEFT,1);
		jumpControll(37,1);
		feelingControll(38,41,FeelType.SILENCE,0);//無言
		jumpControll(39,1);
		feelingControll(41,42,FeelType.OK,0);//〇
		moveControll(42,48,Direction.RIGHT,0);
		moveControll(42,48,Direction.RIGHT,1);
		fadeInControll(44,46,delta,7);
		if(time >= 46 && 48 > time){
			world.getDispHeroList().clear();
			world.getDispHeroList().add(new KaedeGame(new Vector2(440, 50)));
			world.getDispHeroList().add(new VisnuGame(new Vector2(310, 50)));
			world.getDispHeroList().add(new ShinonGame(new Vector2(310, 210)));
		}
		rotateControll(46,48,Direction.BACK,0);
		rotateControll(46,48,Direction.BACK,1);
		//カエデ、ヴィシュヌ、シノン、ゲーム内戦闘
		fadeOutControll(46,48,delta,8);
		feelingControll(48,50,FeelType.SURPRISE,0);//驚き
		feelingControll(48,50,FeelType.SURPRISE,1);//驚き
		feelingControll(50,52,FeelType.SILENCE,2);//無言
		tackleControll(53,Direction.FRONT,2);
		feelingControll(54,55,FeelType.DAMAGE,1);//-10p
		feelingControll(55,57,FeelType.SURPRISE,0);//驚き
		feelingControll(55,57,FeelType.SURPRISE,1);//驚き
		feelingControll(57,59,FeelType.CRY,1);//泣き
		jumpControll(57,1);
		feelingControll(59,64,FeelType.SILENCE,2);//無言
		fadeInControll(62,64,delta,9);
		if(time >= 63 && 64 > time){
			world.getDispHeroList().clear();
			world.getDispHeroList().add(new KaedeGame(new Vector2(440, 50)));
			world.getDispHeroList().add(new VisnuGame(new Vector2(310, 50)));
		}
		rotateControll(63,64,Direction.BACK,0);
		rotateControll(63,64,Direction.BACK,1);
		fadeOutControll(64,65,delta,10);
		fadeInControll(65,67,delta,11);
		if(time >= 66 && 67 > time){
			world.getDispHeroList().clear();
		}
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
		if(world.getDispHeroList().size > listNumber ){
			if(time >= startTime && endTime > time){
				Hero hero = world.getDispHeroList().get(listNumber);
				hero.setSprite();
				world.move(hero, dir);
			}
		}
	}
	public void feelingControll(float startTime ,float endTime,FeelType feelType, int listNumber){
		if(world.getDispHeroList().size > listNumber ){
			if(time >= startTime && endTime > time){
				Hero hero = world.getDispHeroList().get(listNumber);
				hero.setFeelingFlag(hero.feelingFlag.ON);
				hero.setFeelType(feelType);
			}
		}
	}

	public void jumpControll(float startTime,int listNumber){
		if(world.getDispHeroList().size > listNumber ){
			if(time >= startTime && startTime+0.644 > time){
				Hero hero = world.getDispHeroList().get(listNumber);
				hero.setState(hero.state.JUMP);
				world.jump(hero);
			}
		}
	}

	public void tackleControll(float startTime ,Direction dir,int listNumber){
		if(world.getDispHeroList().size > listNumber ){
			if(time >= startTime && startTime+0.2 > time){
				Hero hero = world.getDispHeroList().get(listNumber);
				hero.setSprite();
				world.tackle(hero, dir);
			}
		}
	}
	public void rotateControll(float startTime,float endTime, Direction dir,int listNumber){
		if(world.getDispHeroList().size > listNumber ){
			if(time >= startTime && endTime > time){
				Hero hero = world.getDispHeroList().get(listNumber);
				hero.setDirection(dir);
				hero.setSprite();
			}
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
