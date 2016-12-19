package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PlayUI {
	private HpBar hpBar;
	private PauseButton pauseButton;
	private Sprite scoreImg;
	private float x;
	private float y;
	private float centerX;
	private OrthographicCamera cam;

	private boolean debugMode = true;

	public PlayUI(float x, float y, OrthographicCamera cam){
		hpBar = new HpBar();
		pauseButton = new PauseButton();
		scoreImg = new Sprite(new Texture(Gdx.files.internal("res/scoreUI.png")));
		scoreImg.setPosition(x, y);
		this.cam = cam;
		this.x = x;
		this.y = y;
		this.centerX = this.x + 72;
	}

	public void draw(SpriteBatch batch, ShapeRenderer renderer){
		renderer.setProjectionMatrix(cam.combined);
		renderer.begin(ShapeType.Filled);
		hpBar.drawBar(renderer);
		renderer.end();

		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		scoreImg.draw(batch);
		hpBar.drawFrame(batch);
		pauseButton.draw(batch);
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

	public float getCenterX(){
		return centerX;
	}

	public HpBar getHpBar(){
		return hpBar;
	}
}
