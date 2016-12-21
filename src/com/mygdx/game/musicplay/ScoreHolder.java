package com.mygdx.game.musicplay;

import com.badlogic.gdx.utils.Array;

public class ScoreHolder {
	private Array<Float> newScore = new Array<Float>();

	public ScoreHolder(int n){
		setNewScore(n);
	}

	public Array<Float> getScore(){
		return newScore;
	}

	private void setNewScore(int n){
		if(newScore.size != 0){
			newScore.clear();
		}
		Float[] list = getList(n);
		for(int j = 0; j < list.length; j++){
			newScore.add(list[j]);
		}
	}

	// ここに曲を追加
	private Float[] getList(int n){
		if(n == 0){
			Float[] list = {3.448217f,3.5977669f,7.681545f,8.214545f,9.368165f,10.128116f,10.795054f,11.128263f,11.479932f,12.24654f,13.080251f,13.795899f,14.145591f,14.528849f,15.328529f,15.694996f,16.811253f,17.161268f,18.309052f,19.076372f,19.831184f,20.210175f,21.324305f,22.090729f,22.807709f,23.174582f,23.559261f,24.358847f,25.091784f,25.825241f,26.208143f,26.5901f,27.356022f,28.823553f,29.956856f,30.754923f,31.527248f,33.087433f,33.256172f,33.770493f,34.5397f,34.738617f,35.33847f,36.169254f,36.369682f,36.98581f,37.71927f,37.918648f,38.38663f,38.76986f,39.187313f,40.036655f,40.819946f,41.519604f,42.319366f,42.73494f,43.13594f,43.51891f,43.71906f,43.902077f,44.285503f,44.68645f,45.068478f,45.251846f,45.535007f,46.266365f,46.99948f,47.700855f,48.534256f,49.2879f,50.050022f,50.816685f,51.648594f,52.066082f,52.415546f,53.163586f,53.94706f,54.732628f,55.09834f,55.531483f,56.297955f,57.047817f,57.89729f,58.63068f,59.413517f,60.19668f,60.984055f,62.612465f,62.795864f};
			return list;
		}else{
			Float[] list = {};
			return list;
		}
	}
}
