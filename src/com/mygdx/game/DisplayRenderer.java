package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class DisplayRenderer {
	GameRenderer gameRenderer;

	OrthographicCamera cam;

	public DisplayRenderer(World world, OrthographicCamera cam){
		this.cam = cam;
		gameRenderer = new GameRenderer(this.cam);
	}

	public void render(float delta){
		gameRenderer.render(delta);

	}
}
