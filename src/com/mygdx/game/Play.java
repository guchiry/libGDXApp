package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;

public class Play extends MyScreenAdapter {
	private static final String LOG_TAG = Play.class.getSimpleName();
    SpriteBatch batch;
    Texture img;
    BitmapFont font;
    ShapeRenderer debugRenderer;
    public Play(LibGdxsample game) {
        super(game);
        batch = new SpriteBatch();
        font = new BitmapFont();
        debugRenderer = new ShapeRenderer();
		}
    @Override
    public void resize(int width, int height) {
        Gdx.app.log(LOG_TAG, "resize");
    }
    @Override
    public void show () {
    	Gdx.app.log(LOG_TAG, "show");
    }

    @Override
    public void render (float delta) {
    	Gdx.app.log(LOG_TAG, "render");
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // カラーバッファをクリア
        batch.begin(); // 描画の開始
        font.getData().setScale(1f); 
        font.draw(batch, "play", 365, 175);
        font.draw(batch, "play", 390, 115);
        batch.end(); // 描画の終了
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.rect(150, 350, 500,100);
        debugRenderer.rect(300, 150, 200,50);
        debugRenderer.rect(300, 90, 200,50);
        
        debugRenderer.end();
        if (Gdx.input.justTouched()) {
			game.setScreen(new Result(game));
		}
    }
    @Override
    public void hide() {
        Gdx.app.log(LOG_TAG, "hide");
        dispose();
    }
    @Override
    public void dispose() {
    	 Gdx.app.log(LOG_TAG, "hide");
    font.dispose();
    batch.dispose();
    debugRenderer.dispose();
    }

}
