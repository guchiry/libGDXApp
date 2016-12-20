package com.mygdx.game.musicplay;

import com.badlogic.gdx.utils.Array;

public class ScoreHolder {
	private Array<Integer> newScore = new Array<Integer>();

	public ScoreHolder(int n){
		setNewScore(n);
	}

	public Array<Integer> getScore(){
		return newScore;
	}

	private void setNewScore(int n){
		if(newScore.size != 0){
			newScore.clear();
		}
		Integer[] list = getList(n);
		for(int j = 0; j < list.length; j++){
			newScore.add(list[j]);
		}
	}

	// ここに曲を追加(10以下は入力禁止！制限は、ノーツの速度とかが正式決定してからプログラムします)
	private Integer[] getList(int n){
		if(n == 0){
			Integer[] list = {30,120,130,300,396,500,555,600,645,690,735,780,825};
			return list;
		}else{
			Integer[] list = {60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60};
			return list;
		}
	}
}
