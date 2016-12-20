package com.mygdx.game.musicplay;

import com.badlogic.gdx.utils.Array;

public class NoteGenerater {
	private Array<Float> score = new Array<Float>();

	public NoteGenerater(){
		ScoreHolder scoreHolder = new ScoreHolder(0);
		score = scoreHolder.getScore();
	}

	public Array<Float> getScore(){
		return score;
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
