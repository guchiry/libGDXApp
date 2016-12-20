package com.mygdx.game.musicplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.musicplay.GradeDecision.Grade;

public class Controller {
	private Score score;
	private PlayUI playUi;
	private boolean touchFlag = false;

	public Controller(Score score, PlayUI playUi){
		this.score = score;
		this.playUi = playUi;
	}

	public void touched(){
		if(Gdx.input.justTouched()) touchFlag = true;

		if(touchFlag){
			touchFlag = false;
			score.sound.play();
			score.getDecision().evaluate();
			if(score.getDecision().getGrade() == GradeDecision.Grade.MISS){
				score.getDecision().increaseMissNum();
				score.getDecision().resetComboNum();
				playUi.getHpBar().decreaseHp();
				score.getNoteDisp().removeNote(0);
			}else if(score.getDecision().getGrade() == GradeDecision.Grade.GOOD){
				score.getDecision().increaseGoodNum();
				score.getDecision().resetComboNum();
				score.getNoteDisp().removeNote(0);
			}else if(score.getDecision().getGrade() == GradeDecision.Grade.GREAT){
				score.getDecision().increaseGreatNum();
				score.getDecision().increaseComboNum();
				score.getNoteDisp().removeNote(0);
			}else if(score.getDecision().getGrade() == GradeDecision.Grade.PERFECT){
				score.getDecision().increasePerfectNum();
				score.getDecision().increaseComboNum();
				score.getNoteDisp().removeNote(0);
			}
			score.setTouchTime(0);
		}

		if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
			playUi.setDebugMode();
		}
	}
}
