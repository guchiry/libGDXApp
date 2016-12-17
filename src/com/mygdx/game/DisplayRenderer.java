package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class DisplayRenderer {
	GameRenderer gameRenderer;

	OrthographicCamera cam;

	//change
	public DisplayRenderer(World world,Score score, OrthographicCamera cam){
		this.cam = cam;
		gameRenderer = new GameRenderer(score, this.cam);
	}

	public void render(float delta){
		gameRenderer.render(delta);

	}
}
