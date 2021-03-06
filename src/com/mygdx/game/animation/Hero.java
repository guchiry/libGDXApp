package com.mygdx.game.animation;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Hero {
	public enum State{
		IDLE, WALKING,JUMP,TACKLE
	}
	public enum Direction{
		FRONT, LEFT, RIGHT, BACK
	}
	public enum FeelType{
		GAME2, GAMEYELLOW, GAMEBLUE, EXCLAMATION, ENEMY, OK, SURPRISE, SILENCE, CRY ,DAMAGE
	}
	public enum FeelingFlag{
		ON,OFF
	}


	static final float SPEED = 1f;
	static final float SIZE = 1f;

	private Vector2 position = new Vector2();
//	private HeroDisplay heroDisp = new HeroDisplay();
	Rectangle bounds = new Rectangle();
	Texture img;
	TextureRegion[] front;
	TextureRegion[] left;
	TextureRegion[] right;
	TextureRegion[] back;
	State state = State.IDLE;
	Direction dir = Direction.FRONT;
	FeelingFlag feelingFlag = FeelingFlag.OFF;
	FeelType feelType;

	Sprite sprite;

	Hero hero;
	World world;

	Animation animFront;
	Animation animLeft;
	Animation animRight;
	Animation animBack;

	Feeling feel;

	public Hero(Vector2 position){
		this.position = position;
		this.bounds.x = SIZE;
		this.bounds.y = SIZE;
		feel = new Feeling(new Vector2(position),this);
		sprite = new Sprite();
	}

	public void initImg(){
		front = new TextureRegion(img).split(16, 16)[0];
		left = new TextureRegion(img).split(16, 16)[1];
		right = new TextureRegion(img).split(16, 16)[2];
		back = new TextureRegion(img).split(16, 16)[3];
		animFront = new Animation(0.15f, front[0], front[1], front[2], front[1]);
		animLeft = new Animation(0.15f, left[0], left[1], left[2], left[1]);
		animRight = new Animation(0.15f, right[0], right[1], right[2], right[1]);
		animBack = new Animation(0.15f, back[0], back[1], back[2], back[1]);
	}

	public Vector2 getPosition(){
		return position;
	}

	public Feeling getFeeling(){
		return feel;
	}

	public Rectangle getBounds(){
		return bounds;
	}

	public Sprite getSprite(){
		return sprite;
	}

	public State getState() {
		return state;
	}

	public FeelingFlag getFeelingFlag() {
		return feelingFlag;
	}
	public FeelType getFeelType() {
		return feelType;
	}

	public void setSprite(){
		if(dir == Hero.Direction.FRONT) sprite = new Sprite(front[1]);
		if(dir == Hero.Direction.BACK) sprite = new Sprite(back[1]);
		if(dir == Hero.Direction.LEFT) sprite = new Sprite(left[1]);
		if(dir == Hero.Direction.RIGHT) sprite = new Sprite(right[1]);
	}

	public void setState(State newState) {
		this.state = newState;
	}

	public void setDirection(Direction dir){
		this.dir = dir;
	}

	public void setFeelingFlag(FeelingFlag flag) {
		this.feelingFlag = flag;
	}

	public void setFeelType(FeelType feelType) {
		this.feelType = feelType;
	}

	public void setPosition(Vector2 position){
		this.position = position;
	}
	public Animation currentAnim() {
	    Animation anim = null ;

	    if (state == State.WALKING) {
	        if (dir == Direction.FRONT) anim = animFront;
	        if(dir == Direction.LEFT)  anim = animLeft;
	        if (dir == Direction.RIGHT) anim = animRight;
	        if(dir == Direction.BACK)  anim = animBack;
	    }
	    return anim;
	}
}
