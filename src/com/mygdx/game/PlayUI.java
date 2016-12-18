package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PlayUI {
	private ShapeRenderer renderer;
	private SpriteBatch batch;
	private HpBar hpBar;
	private float x;
	private float y;
	private float centerX;
	private float centerY;

	private boolean debugMode = true;

	public PlayUI(float x, float y){
		renderer = new ShapeRenderer();
		batch = new SpriteBatch();
		hpBar = new HpBar();
		this.x = x;
		this.y = y;
		this.centerX = this.x + 80;
		this.centerY = this.y + 80;
	}

	public void drawShapeRenderer(){
		renderer.begin(ShapeType.Filled);
		hpBar.drawBar(renderer);
		renderer.end();

		batch.begin();
		hpBar.drawFrame(batch);
		batch.end();

		if(debugMode){
			renderer.begin(ShapeType.Line);
			renderer.setColor(0,1,0,1);
			renderer.rect(1, 0, Setting.LOGICAL_WIDTH-1, Setting.LOGICAL_HEIGHT-1);
			renderer.end();
		}

	}

	public void setDebugMode(){
		debugMode = !debugMode;
	}

	public ShapeRenderer getShapeRenderer(){
		drawShapeRenderer();
		return this.renderer;
	}

	public float getCenterX(){
		return centerX;
	}

	public float getCenterY(){
		return centerY;
	}

	public HpBar getHpBar(){
		return hpBar;
	}
}
