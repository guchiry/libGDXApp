package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class NumberTextureRegion {
	TextureRegion[] img;

	public NumberTextureRegion(){
		img = new TextureRegion(new Texture(Gdx.files.internal("res/Number12-20.png"))).split(12, 20)[0];
	}

	public TextureRegion getTexture(int num){
		if(num <= 9) return img[num];
		return null;
	}
}
