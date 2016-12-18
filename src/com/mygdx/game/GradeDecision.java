package com.mygdx.game;

public class GradeDecision {
	public enum Grade{
		PERFECT, GREAT, GOOD, MISS,
	}

	private Score score;
	private int successNum = 0;
	private int missNum = 0;

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

	//通り過ぎたやつ　まだ来てない奴　近いほうを判定
	public float getDistance(){
		float distance = Setting.MAX_DISTANCE;
		if(!score.getNoteDisp().isEmpty()){
			distance = score.getScoreUI().getCenterX() - score.getNoteDisp().getLatestNote().getPosition().x;
			if(distance < 0) distance = -distance;

		}
		return distance;
	}

	public String getString(){
		if(grade == Grade.PERFECT){
			return "PERFECT";
		}else if(grade == Grade.GREAT){
			return "GREAT";
		}else if(grade == Grade.GOOD){
			return "GOOD";
		}else if(grade == Grade.MISS){
			return "MISS";
		}
		return "";
	}

	public int getSuccessNum(){
		return successNum;
	}

	public int getMissNum(){
		return missNum;
	}

	public void increaseSuccessNum() {
		this.successNum++;
	}

	public void increaseMissNum() {
		this.missNum++;
	}

	public Grade getGrade() {
		return grade;
	}
}
