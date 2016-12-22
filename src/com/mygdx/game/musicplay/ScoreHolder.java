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
			Float[] list = {6.540535f,8.706346f,9.457619f,10.222954f,10.940842f,12.289902f,13.03045f,13.753955f,14.120909f,14.453624f,15.276892f,16.005438f,16.74223f,17.138245f,17.520508f,18.28729f,18.671162f,19.753824f,20.136175f,20.924461f,21.66984f,22.419775f,22.79033f,23.186224f,24.300926f,25.017027f,25.76688f,26.15001f,26.551071f,27.334852f,28.05112f,28.80083f,29.200586f,29.566336f,29.933746f,30.321398f,30.700563f,31.049946f,31.8169f,32.18303f,32.54951f,33.31524f,34.014835f,34.813683f,35.19723f,35.613167f,36.38179f,36.86264f,37.63582f,38.296516f,39.130573f,39.880444f,40.495934f,40.896797f,41.462357f,42.196526f,42.97923f,43.56252f,44.113853f,44.494663f,45.295082f,46.060093f,46.642662f,47.02723f,47.59285f,48.37773f,48.56071f,49.14402f,49.34279f,49.94364f,50.14369f,50.710106f,50.91009f,51.476578f,52.26098f,53.025043f,53.409245f,53.80798f,54.57541f,55.358566f,55.75848f,56.525097f,56.858685f,57.25794f,58.02409f,58.82387f,59.59051f,59.955833f,60.39015f,60.773396f,61.173134f,61.55647f,61.972954f,62.12315f,62.522953f,62.72184f,63.15493f,63.887775f,65.35622f};
			return list;
		}else{
			Float[] list = {};
			return list;
		}
	}
}
