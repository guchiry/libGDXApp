package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class WorldRenderer {
	GameRenderer gameRenderer;

	OrthographicCamera cam;

	public WorldRenderer(World world,Score score, OrthographicCamera cam){
		this.cam = cam;
		gameRenderer = new GameRenderer(score, this.cam);
	}

	public void render(float delta){
		gameRenderer.render(delta);
	}
}
