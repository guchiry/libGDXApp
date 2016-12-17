package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PauseButton {

	public void draw(ShapeRenderer renderer){
		renderer.begin(ShapeType.Filled);
		renderer.setColor(0.5f,0.5f,0.5f,1);
		renderer.rect(770, 450, 30, 30);
		renderer.end();
		renderer.begin(ShapeType.Line);
		renderer.setColor(1f, 1f, 1f, 1);
		renderer.rect(770, 449, 30, 30);
		renderer.end();
	}
}
