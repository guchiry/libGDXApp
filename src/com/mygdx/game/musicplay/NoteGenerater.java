package com.mygdx.game.musicplay;

import com.badlogic.gdx.utils.Array;

public class NoteGenerater {
	private Array<Float> score = new Array<Float>();
	private int noteNum;

	public NoteGenerater(){
		ScoreHolder scoreHolder = new ScoreHolder(0);
		score = scoreHolder.getScore();
		noteNum = score.size;
	}

	public Array<Float> getScore(){
		return score;
	}

	public int getNoteNum(){
		return noteNum;
	}

	public Float getLateNote(){
		return score.first();
	}

	public void removeNote(int i){
		if(!this.isEmpty()) score.removeIndex(i);
	}

	public boolean isEmpty(){
		if(score.size == 0) return true;
		else return false;
	}
}
