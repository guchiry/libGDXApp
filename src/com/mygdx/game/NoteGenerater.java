package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class NoteGenerater {
	private Array<Integer> score = new Array<Integer>();

	public NoteGenerater(){
		ScoreHolder scoreHolder = new ScoreHolder(0);
		score = scoreHolder.getScore();
	}

	public Array<Integer> getScore(){
		return score;
	}

	public int getLateNote(){
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
