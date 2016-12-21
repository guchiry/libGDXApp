package com.mygdx.game.musicplay;

public class GradeDecision {
	public enum Grade{
		PERFECT, GREAT, GOOD, MISS,
	}

	private Score score;
	private int perfectNum = 0;
	private int greatNum = 0;
	private int goodNum = 0;
	private int missNum = 0;
	private int scoreNum = 0;
	private int combo = 0;

	private Grade grade = null;

	public GradeDecision(Score score){
		this.score = score;
	}

	public void evaluate(){
		float distance = getDistance();
		if(distance <= Setting.PERFECT_DISTANCE){
			grade = Grade.PERFECT;
		}else if(distance <= Setting.GREAT_DISTANCE){
			grade = Grade.GREAT;
		}else if(distance <= Setting.GOOD_DISTANCE){
			grade = Grade.GOOD;
		}else if(distance <= Setting.MISS_DISTANCE){
			grade = Grade.MISS;
		}else if(score.getNoteDisp().isEmpty()){
			grade = null;
		}else{
			grade = null;
		}
	}

	public float getDistance(){
		float distance = Setting.MAX_DISTANCE;
		if(!score.getNoteDisp().isEmpty()){
			distance = score.getPlayUI().getCenterX() - score.getNoteDisp().getLatestNote().getPosition().x;
			if(distance < 0) distance = -distance;
		}
		return distance;
	}

	public String getString(){
		if(grade == Grade.PERFECT){
			return "PERFECT";
		}else if(grade == Grade.GREAT){
			return "  GREAT";
		}else if(grade == Grade.GOOD){
			return "   GOOD";
		}else if(grade == Grade.MISS){
			return "   MISS";
		}
		return "";
	}

	public int getPerfectNum(){
		return perfectNum;
	}

	public int getMissNum(){
		return missNum;
	}

	public int getComboNum(){
		return combo;
	}

	public void increaseComboNum(){
		this.combo++;
	}

	public void resetComboNum(){
		this.combo = 0;
	}

	public void increasePerfectNum() {
		this.perfectNum++;
	}

	public void increaseGreatNum() {
		this.greatNum++;
	}

	public void increaseGoodNum() {
		this.goodNum++;
	}

	public void increaseMissNum() {
		this.missNum++;
	}

	public Grade getGrade() {
		return grade;
	}

	public void finalGrade() {
		GradeNum.perfect = perfectNum;
		GradeNum.great = greatNum;
		GradeNum.good = goodNum;
		GradeNum.miss = missNum;
		GradeNum.combo = combo;
		GradeNum.score = goodNum*50 + greatNum*100 + perfectNum*200;
	}
}
