package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Sequence {
	NumberList numList;
	NumberTextureRegion numImg;

	public Sequence(){
		 numImg = new NumberTextureRegion();
	}

	public void draw(SpriteBatch batch, float x, float y, int num){
		numList = new NumberList(num);

		int i = 0;

		while( i < numList.size() ){
			int n = numList.get(i);
			TextureRegion img = numImg.getTexture(n);
			batch.draw(img, x + i * (img.getRegionWidth()+4), y);
			i++;
		}
	}
}
