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
			Float[] list = {6.413389f,6.5132513f,10.029327f,10.412487f,12.278363f,13.027981f,13.794452f,14.161016f,14.543022f,15.310048f,16.060371f,16.79348f,17.143337f,17.509857f,17.893646f,18.309649f,18.708218f,19.497683f,19.842447f,20.175673f,21.00879f,21.375282f,22.09174f,22.808203f,23.174667f,24.341076f,25.090797f,25.89047f,26.540318f,27.289978f,27.989613f,28.805586f,29.572208f,29.955833f,30.322674f,31.105337f,31.505356f,31.870316f,32.571587f,33.32196f,34.137928f,34.88681f,35.287384f,36.392105f,37.175137f,38.01999f,38.753033f,39.50286f,40.319935f,41.08673f,41.870064f,42.620014f,43.40279f,44.1701f,44.919865f,45.686913f,46.50283f,47.253014f,48.020134f,48.786816f,48.96979f,49.56994f,50.33697f,50.51982f,51.120144f,51.91978f,52.125217f,52.302803f,52.502716f,52.704727f,53.493073f,53.674816f,53.87461f,54.052944f,54.219734f};
			return list;
		}else{
			Float[] list = {};
			return list;
		}
	}
}
