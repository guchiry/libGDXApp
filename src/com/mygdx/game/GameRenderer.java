package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {
	private Score score;

	SpriteBatch batch;
	OrthographicCamera cam;
	BitmapFont font;
	ShapeRenderer renderer = new ShapeRenderer();
	Sprite img;

	public GameRenderer(Score score, OrthographicCamera cam){
		this.score = score;
		this.cam = cam;
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(1, 0, 0, 1);
		font.getData().setScale(1.5f);
		img = new Sprite(new Texture(Gdx.files.internal("res/scoreUI.png")));
	}

	private void update(float delta){
		score.update(delta);
	}

	private void draw(float delta){
		this.cam.update();

		// ScoreUIの描画
		renderer.setProjectionMatrix(cam.combined);
		ScoreUI scoreui = score.getScoreUI();
		renderer = scoreui.getShapeRenderer();

		//　ノーツ(ライン)の描画
		renderer.setProjectionMatrix(cam.combined);
		renderer.begin(ShapeType.Line);
		if(!score.getNoteDisp().isEmpty()){
			for(Note note : score.getNoteDisp().getNotesList()){
				renderer.setColor(1, 1, 0, 1);
				renderer.line(note.getPosition().x, note.getPosition().y-40, note.getPosition().x, note.getPosition().y+40);
			}
		}
		renderer.end();

		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		// scoreUIの描画
		img.setPosition(254, 380);
		img.setScale(3f);
		img.draw(batch);
		// ノーツ(画像部分)の描画
		if(!score.getNoteDisp().isEmpty()){
			for(Note note : score.getNoteDisp().getNotesList()){
				note.getSprite().setPosition(note.getPosition().x-8, note.getPosition().y-8);
				note.getSprite().draw(batch);
			}
		}
		//文字描画
		font.draw(batch, "Success:" + score.getDecision().getSuccessNum() + " Miss:" + score.getDecision().getMissNum(), 10, 40);
		if(score.getTouchTime() < Setting.DICISION_FADE_TIME) font.draw(batch, score.getDicisionStr(), 20, 440);

		batch.end();
	}

	public void render(float delta){
		update(delta);
		draw(delta);
	}

	public void dispose(){
		score.sound.dispose();
		font.dispose();
		batch.dispose();
	}
}