package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class DisplayRenderer {
	private World world;

	GameRenderer gameRenderer;
	WorldRenderer worldRenderer;

	OrthographicCamera cam;

	public DisplayRenderer(OrthographicCamera cam){
		this.cam = cam;
		world = new World(cam);

		worldRenderer = new WorldRenderer(world, cam);
		gameRenderer = new GameRenderer(this.cam);
	}

	public void render(float delta){
		worldRenderer.render(delta);
		gameRenderer.render(delta);
	}
}
