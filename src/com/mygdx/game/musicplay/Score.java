package com.mygdx.game.musicplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Score {
	private PlayUI playUi;
	private GradeDecision decision;
	private NoteDisplay noteDisp;
	private Controller controller;

	private OrthographicCamera cam;

	Sound sound;

	//タッチ関係
	private float touchTime = 0;
	public boolean gameOverFlag = false;
	public boolean endFlag = false;

	public Score(OrthographicCamera cam){
		this.cam = cam;
		noteDisp = new NoteDisplay();
		playUi = new PlayUI(80, 332, cam);
		decision = new GradeDecision(this);
		controller = new Controller(this, playUi);

		sound = Gdx.audio.newSound(Gdx.files.internal("res/" + "TouchSE.wav"));
	}

	public void update(float delta){
		touchTime += delta;

		noteDisp.createNote(delta);

		if(!noteDisp.isEmpty()){
			noteDisp.update();
			if(noteDisp.getLatestNote().getPosition().x <= 132){
				noteDisp.removeNote(0);
				decision.increaseMissNum();
				decision.resetComboNum();
				playUi.getHpBar().decreaseHp();
			}
		}

		controller.touched();

		if(playUi.getHpBar().getHp() <= 0){
			gameOverFlag  = true;
		}

		if(GradeNum.playTime >= 70){
			endFlag  = true;
		}
	}

	public PlayUI getPlayUI(){
		return playUi;
	}


	public NoteDisplay getNoteDisp(){
		return noteDisp;
	}

	public String getDicisionStr(){
		return decision.getString();
	}

	public float getTouchTime(){
		return touchTime;
	}

	public GradeDecision getDecision() {
		return decision;
	}

	public void setTouchTime(int time) {
		touchTime = time;
	}
}
