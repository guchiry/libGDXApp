package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Map1 {
	Texture map1Texture;

	public Map1(){
		map1Texture = new Texture(Gdx.files.internal("SampleEventMap.png"));
	}

	public Texture getBgTexture(){
		return map1Texture;
	}
}
