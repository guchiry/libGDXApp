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

	// ここに曲を追加(10以下は入力禁止！制限は、ノーツの速度とかが正式決定してからプログラムします)
	private Float[] getList(int n){
		if(n == 0){
			Float[] list = {6.6303334f,6.764079f,9.129538f,10.445549f,12.361618f,13.111636f,13.844773f,14.211568f,
					14.544489f,15.344065f,16.098719f,16.843828f,17.193771f,17.559862f,18.376299f,18.759533f,19.109365f,
					19.892525f,20.242352f,20.625582f,21.42494f,22.156958f,22.924791f,23.291958f,24.407108f,25.15749f,
					25.85714f,26.574066f,27.37355f,28.139658f,28.839514f,29.572872f,30.339163f,30.705614f,
					31.88846f,32.288532f,33.421402f,34.221058f,35.454067f,35.887287f,36.536953f,37.236305f,37.95342f,
					38.737907f,39.55268f,39.919262f,40.352406f,41.11891f,41.501923f,41.86886f,42.618397f,43.41794f,
					44.20109f,44.967403f,45.73432f,46.50033f,47.316708f,47.699913f,48.11643f,48.516396f,48.716385f,
					48.883423f,49.082848f,49.24986f,49.466328f,49.63306f,49.832474f,50.031002f,50.230923f,50.41438f,
					50.59724f,50.782536f,50.96568f,51.16567f,51.36538f,51.58146f,51.764866f,51.94807f,52.147366f,
					52.34678f,52.54844f,52.732044f,52.948467f,53.137066f,53.331287f,53.514503f,53.698246f,53.88158f,
					54.064793f,54.248013f,54.464314f};
			return list;
		}else{
			Float[] list = {};
			return list;
		}
	}
}
