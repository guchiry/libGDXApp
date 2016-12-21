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
			Float[] list = {6.080338f,6.230031f,9.412462f,12.326906f,13.059879f,13.776932f,14.176742f,14.559331f,15.314063f,16.076838f,16.80975f,17.209587f,17.592829f,18.34268f,18.726313f,19.842072f,20.225363f,21.341547f,22.091333f,22.857924f,23.274115f,24.357538f,25.10783f,25.806757f,26.189907f,26.539782f,27.32269f,28.089453f,28.789331f,29.189032f,29.555452f,30.271915f,30.705061f,31.808765f,32.204548f,32.98776f,33.70387f,34.453804f,36.136658f,36.734787f,37.585938f,38.319244f,39.152084f,39.901936f,40.734932f,41.5015f,41.901474f,42.271725f,42.984188f,43.8006f,44.53357f,45.3164f,46.083157f,46.882805f,47.23278f,47.61599f,48.4393f,48.61561f,49.215466f,49.41529f,49.99866f,50.165745f,50.714863f,50.881668f,51.46485f,51.64806f,52.31437f,52.503803f,53.114098f,53.28096f,53.863865f,54.04712f,54.6469f,55.03016f,55.43004f,56.19696f,56.97953f,57.745922f,58.545673f,59.312042f,59.66208f,60.07849f,60.448948f,60.878304f,61.59476f,62.377953f,62.76176f,63.144497f,63.495045f,63.911667f,66.28369f};
			return list;
		}else{
			Float[] list = {};
			return list;
		}
	}
}
